package com.application.urlShortener.Repository;

import org.springframework.stereotype.Repository;

import redis.clients.jedis.Jedis;

@Repository
public class UrlShortenerRepository {

	private final Jedis jedis;
    private final String idKey;
    private final String urlKey;

    public UrlShortenerRepository() {
        this.jedis = new Jedis();
        this.idKey = "id";
        this.urlKey = "url";
    }

    public UrlShortenerRepository(Jedis jedis, String idKey, String urlKey) {
        this.jedis = jedis;
        this.idKey = idKey;
        this.urlKey = urlKey;
    }

    public Long incrementID() {
        Long id = jedis.incr(idKey);
        return id - 1;
    }
    
    public String getIDIfExists(String url) {
        String id = jedis.hget(urlKey, url);
        return id;
    }

    public void saveUrl(String key, String longUrl) {
        jedis.hset(urlKey, key, longUrl);
        jedis.hset(urlKey, longUrl, key);
    }

    public String getUrl(Long id) {
        return jedis.hget(urlKey, String.valueOf(id));
    }

}
