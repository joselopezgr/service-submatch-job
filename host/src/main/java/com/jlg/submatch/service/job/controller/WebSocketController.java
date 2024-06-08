package com.jlg.submatch.service.job.controller;

import com.jlg.submatch.service.job.mailing.SendEmail;
import com.jlg.submatch.service.job.model.Job;
import com.jlg.submatch.service.job.model.helpers.Applicant;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/jobs")
public class WebSocketController {

    private final SimpMessagingTemplate template;

    private final List<Job> jobs;

    private final SendEmail sendEmail;

    public WebSocketController(SimpMessagingTemplate template, List<Job> job, SendEmail sendEmail) {
        this.template = template;
        this.jobs = job;
        this.sendEmail = sendEmail;
    }

    @GetMapping("/retrieve")
    public List<Job> getJobs() {
        return jobs;
    }

    @GetMapping("/retrieve/{orgId}")
    public List<Job> getJob(@PathVariable UUID orgId) {
        return jobs.stream().filter(j -> j.getOrganisationId().equals(orgId)).toList();
    }

    @PostMapping("/post")
    public String postJob(@RequestBody Job job) {
        job.setId(UUID.randomUUID());
        jobs.add(job);
        template.convertAndSend("/topic/jobs", job);
        return "Job posted successfully" + job.getId();
    }

    @PostMapping("/apply")
    public synchronized String applyJob(@RequestParam UUID jobId, @RequestBody Applicant applicantId) {
        Job job = jobs.stream().filter(j -> j.getId().equals(jobId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Job not found"));

        List<String> applicantsIds = job.getApplicantsIds();
        if(applicantsIds == null) {
            applicantsIds = new ArrayList<>();
        }
        applicantsIds.add(applicantId.getApplicantId());
        job.setApplicantsIds(applicantsIds);
        template.convertAndSend("/topic/jobs", job);
        return "Job application submitted";

    }

    @PostMapping("/accept/{jobId}/applicant")
    public String acceptApplicant(@PathVariable UUID jobId, @RequestBody Applicant applicantId, @RequestParam String applicantEmail) {
        sendEmail.sendSimpleMessage(applicantEmail, "Job application accepted", "Congratulations! Your job application has been accepted.");

        Job job = jobs.stream().filter(j -> j.getId().equals(jobId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Job not found"));


        String acceptedApplicantId = applicantId.getApplicantId();
        job.setAcceptedApplicantId(acceptedApplicantId);

        template.convertAndSend("/topic/jobs", job);

        return "Applicant accepted";
    }

    @MessageMapping("/delete")
    public void deleteJob(@RequestBody String jobId) {
        System.out.println("The method is called!!");
        UUID jobIdUUID = UUID.fromString(jobId);
        Job job = jobs.stream().filter(j -> j.getId().equals(jobIdUUID))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Job not found"));

        jobs.remove(job);
        job.setIsDeleted(true);
        System.out.println("Job deleted: " + job);
        template.convertAndSend("/topic/jobs", job);
    }

    @MessageExceptionHandler
    public void handleException(Exception e) {
        System.out.println("Error handling message: " + e.getMessage());
    }
}
