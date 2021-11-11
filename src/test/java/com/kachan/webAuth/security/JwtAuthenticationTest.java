package com.kachan.webAuth.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JwtAuthenticationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Test
    void shouldNotAllowAccessToUnauthenticatedUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(status().isUnauthorized());
    }

    @Test
    public void shouldGenerateAuthToken() throws Exception {
        String token = jwtTokenProvider.createToken("user@gmail.com", "USER");

        assertNotNull(token);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/hello")
                        .header("Authorization", token))
                .andExpect(status().isOk());
    }
}
