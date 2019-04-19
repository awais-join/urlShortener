package com.application.urlShortener.Service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.application.urlShortener.Repository.UrlShortenerRepository;

@RunWith(SpringRunner.class)
public class UrlShortenerServiceTest {

    @Mock
    private UrlShortenerRepository urlShortenerRepository;
    
	@InjectMocks
	private UrlShortenerService urlShortenerService;
    
    @Test
    public void testGetShortenURLID() throws Exception {
    	String url = "www.google.com";
        when(urlShortenerRepository.incrementID()).thenReturn(0L);
        when(urlShortenerRepository.getIDIfExists(url)).thenReturn(null);
        String actual = urlShortenerService.getShortenURLID(url);
        String expected = "a";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetOriginalURL() throws Exception {
    	String url = "www.google.com";
        when(urlShortenerRepository.getUrl(0L)).thenReturn(url);
        String actual = urlShortenerService.getOriginalURL("a");
        String expected = url;
        assertEquals(expected, actual);
    }
    

}
