package com.application.urlShortener;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.application.urlShortener.Controller.UrlShortenerController;
import com.application.urlShortener.Repository.UrlShortenerRepository;
import com.application.urlShortener.Service.UrlShortenerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlShortenerApplicationTests {

    @Autowired
    private UrlShortenerController urlShortenerController;
    
    @Autowired
    private UrlShortenerService urlShortenerService;
    
    @Autowired
    private UrlShortenerRepository urlShortenerRepository; 

    @Test
    public void contexLoads() throws Exception {
        assertThat(urlShortenerController).isNotNull();
        assertThat(urlShortenerService).isNotNull();
        assertThat(urlShortenerRepository).isNotNull();

    }

}
