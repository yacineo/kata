package com.kata.backend;

import com.kata.backend.controller.KataController;
import com.kata.backend.service.IkataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(KataController.class)
public class KataControllerTest {

    @Autowired
    private MockMvc mockMvc;  // MockMvc to simulate HTTP requests

    @MockBean
    private IkataService kataService;  // Mock the IkataService

    @Test
    public void testTransform() throws Exception {
        // Arrange
        int number = 3;
        String expectedResponse = "FOOFOO";  // Example expected response

        // Mock the service response
        when(kataService.transformNumber(number)).thenReturn(expectedResponse);

        // Act and Assert
        mockMvc.perform(get("/transform/{number}", number))
                .andExpect(status().isOk())  // Expect HTTP 200 OK response
                .andExpect(content().string(expectedResponse));  // Verify the content
    }
}