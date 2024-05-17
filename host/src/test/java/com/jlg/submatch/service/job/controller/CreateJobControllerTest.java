//package com.jlg.submatch.service.job.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jlg.submatch.service.job.helpers.JobRequestDTO;
//import com.jlg.submatch.service.job.model.Job;
//import com.jlg.submatch.service.job.service.JobService;
//import org.junit.jupiter.api.*;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(CreateJobController.class)
//public class CreateJobControllerTest {
//
//    @MockBean
//    JobService jobService;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @BeforeEach
//    void setUp(WebApplicationContext applicationContext) {
//        mockMvc = MockMvcBuilders
//                .webAppContextSetup(applicationContext)
//                .build();
//    }
//
//    @Nested
//    @DisplayName("Create a Job record")
//    class CreateTests {
//        @Mock
//        private Job mockJob;
//
//        @Mock
//        private JobRequestDTO userRequest;
//
//        @BeforeEach
//        void setUp() {
//            mockJob = Job.builder()
//                    .firstName("firstName")
//                    .lastName("lastName")
//                    .email("email")
//                    .password("password")
//                    .phone("phone")
//                    .address("address")
//                    .role(UserRole.USER)
//                    .build();
//
//            JobRequestDTO userRequest = new JobRequestDTO();
//            userRequest.setFirstName("fistName");
//            userRequest.setLastName("lastName");
//            userRequest.setEmail("email");
//            userRequest.setPassword("password");
//            userRequest.setPhone("phone");
//            userRequest.setAddress("address");
//            userRequest.setRole(String.valueOf(UserRole.ADMIN));
//        }
//
//        @Test
//        @DisplayName("will return 201 if a job record was created")
//        void shouldCreateUserRecord() throws Exception {
//
//            when(jobService.create(any(Job.class))).thenReturn(mockJob);
//
//            mockMvc.perform(post("/job")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(objectMapper.writeValueAsString(userRequest)))
//                    .andExpect(status().isCreated());}
//    }
//}
