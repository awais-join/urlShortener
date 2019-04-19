package com.application.urlShortener.Controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.application.urlShortener.Service.UrlShortenerService;

@RunWith(SpringRunner.class)
@WebMvcTest(UrlShortenerController.class)
public class UrlShortenerControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private UrlShortenerService service;
    
    @Test
    public void testHomePageMethod() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("<h1>URL Shortener</h1>")));
    }
    
    @Test
    public void testShortenURLMethod() throws Exception {
        when(service.getShortenURLID(null)).thenReturn("testID");
        this.mockMvc.perform(post("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("testID")));
    }
    
    @Test
    public void testRedirectURLMethod() throws Exception {
        when(service.getOriginalURL("0")).thenReturn("www.google.com");
        this.mockMvc.perform(get("/0")).andDo(print()).andExpect(status().is(302))
                .andExpect(view().name("redirect:http://www.google.com"));
    }

}
