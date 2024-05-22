package com.sparta.idg.mockmvctestingdemo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class MockmvcTestingDemoApplicationTests {

  @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Testing welcome page")
    void testWelcomePage() throws Exception {

      this.mockMvc.perform(get("/"))
              .andExpect(view().name("welcome"))// Check the correct view is returned
              .andExpect(content().contentType("text/html;charset=UTF-8"))// Check we get HTML back
              .andExpect(status().isOk()) // Check status code is 2XX
              .andExpect(header().string("Content-Language","en"))// Checking one of the response headers
              .andExpect(content().string(containsString("Welcome")))// Checking the contents of the HTML response
              .andDo(print());// Printing the output



      /*mockMvc.perform(get("/"))
                .andDo(print());*/

      //using Junit
      /*int status = mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andReturn()
                .getResponse()
                .getStatus();
        Assertions.assertEquals(200,status);*/

    }

}
