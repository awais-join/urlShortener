package com.application.urlShortener.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.application.urlShortener.Model.URLObject;


@Controller
public class UrlShortenerController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(ModelMap map) {
    	map.addAttribute("urlObject", new URLObject());
        return "index";
    }
    
    @PostMapping("/")
    public String greetingSubmit(@ModelAttribute URLObject urlObject, ModelMap map) {
    	urlObject.setConvertedURL("123456");
    	map.addAttribute("urlObject", urlObject);
        return "index";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String homePage(@PathVariable("id") int id) {
        String redirectUrl = "http://www.google.com";
    	return "redirect:" + redirectUrl;
    }
}