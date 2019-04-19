package com.application.urlShortener.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.application.urlShortener.Model.URLRequestObject;
import com.application.urlShortener.Service.UrlShortenerService;


@Controller
public class UrlShortenerController {
	
    private final UrlShortenerService urlShortenerService;

    public UrlShortenerController(UrlShortenerService urlConverterService) {
        this.urlShortenerService = urlConverterService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(ModelMap map) {
    	map.addAttribute("urlObject", new URLRequestObject());
        return "index";
    }
    
    @PostMapping("/")
    public String shortenURL(@ModelAttribute URLRequestObject urlObject, ModelMap map) {
        String id = urlShortenerService.getShortenURLID(urlObject.getOriginalURL());
    	urlObject.setShortenedURLID(id);
    	map.addAttribute("urlObject", urlObject);
        return "index";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String homePage(@PathVariable("id") String id) throws Exception {
        String redirectUrl = urlShortenerService.getOriginalURL(id);
        redirectUrl = !redirectUrl.startsWith("http") ? "http://" + redirectUrl: redirectUrl;
    	return "redirect:" + redirectUrl;
    }
}