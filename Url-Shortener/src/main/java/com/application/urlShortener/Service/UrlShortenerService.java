package com.application.urlShortener.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.urlShortener.Repository.UrlShortenerRepository;
import com.application.urlShortener.Util.IDBaseConverter;

@Service
public class UrlShortenerService {

    private final UrlShortenerRepository urlShortenerRepository;

    @Autowired
    public UrlShortenerService(UrlShortenerRepository urlRepository) {
        this.urlShortenerRepository = urlRepository;
    }

    public String getShortenURLID(String url) {
    	String uniqueID = urlShortenerRepository.getIDIfExists(url);
    	if(uniqueID == null) {
            Long id = urlShortenerRepository.incrementID();
            uniqueID = IDBaseConverter.INSTANCE.createUniqueID(id);
            urlShortenerRepository.saveUrl(String.valueOf(id), url);
    	} else {
            uniqueID = IDBaseConverter.INSTANCE.createUniqueID(Long.valueOf(uniqueID));
    	}

        return uniqueID;
    }

    public String getOriginalURL(String uniqueID) throws Exception {
        Long dictionaryKey = IDBaseConverter.INSTANCE.getDictionaryKeyFromUniqueID(uniqueID);
        String longUrl = urlShortenerRepository.getUrl(dictionaryKey);
        return longUrl;
    }
}