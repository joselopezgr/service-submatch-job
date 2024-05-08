//package com.jlg.submatch.service.job.model;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//public class JobTest {
//    UUID id = UUID.randomUUID();
//    String name = "name";
//    String lastName = "name";
//    String email = "email";
//    String password = "password";
//    String phone = "phone";
//    String address = "address";
//    UserRole role = UserRole.ADMIN;
//
//    @DisplayName("Should create a Job instance")
//    @Test
//
//    //ARRANGE
//    void shouldCreateUserInstance() {
//        Job job = Job.builder()
//                .firstName(name)
//                .lastName(lastName)
//                .email(email)
//                .password(password)
//                .phone(phone)
//                .address(address)
//                .role(role)
//                .build();
//
//        //ASSERT
//        assertAll(
//                () -> assertEquals(name, job.getFirstName()),
//                () -> assertEquals(lastName, job.getLastName()),
//                () -> assertEquals(email, job.getEmail()),
//                () -> assertEquals(password, job.getPassword()),
//                () -> assertEquals(phone, job.getPhone()),
//                () -> assertEquals(address, job.getAddress()),
//                () -> assertEquals(role, job.getRole())
//        );
//    }
//
//    @DisplayName("Should create a Job instance with default id")
//    @Test
//    void shouldCreateUserInstanceWithDefaultId() {
//        Job job = Job.builder()
//                .firstName(name)
//                .lastName(lastName)
//                .email(email)
//                .password(password)
//                .phone(phone)
//                .address(address)
//                .role(role)
//                .build();
//
//        assertNull(job.getId());
//    }
//}
