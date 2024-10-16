package com.Banking.Banking_app.controller;

import com.Banking.Banking_app.entity.Account;
import com.Banking.Banking_app.service.AccountService;
import com.Banking.Banking_app.service.impl.Accountserviceimpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AccountControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;


    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();  // Set up MockMvc
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testCreateAccount() throws Exception {
        String requestBody = "{ \"accountHolderName\": \"John Doe\", \"balance\": 5000.0 }";

        // Perform the POST request and capture the response
        MvcResult result = mockMvc.perform(post("/api/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andReturn();

        // Get the response body as a string
        String responseBody = result.getResponse().getContentAsString();
        System.out.println("Response Body: " + responseBody); // Print the response for debugging

        // Assert the response status and check JSON path
        mockMvc.perform(post("/api/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated());

    }
}