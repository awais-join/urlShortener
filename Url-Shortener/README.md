# URL Shortener 

URL Shortener helps to generate short url for given url. 
This web application built using Java, Spring Boot and Redis(in-memory data structure store)

## Approach

For each incoming request for URL shorten i used redis to generate(Increment) base10 id. Then i convert base10 id to base62 id. 
Used Jedis(Redis client for Java) to store base62 id as key and URL value. I used double posting approach for accessing existing base62 id for existing url in store. 

## Installation

Use this Spring Boot project to import into STS or Eclipse to run as Spring Boot app.
This application requires running redis server (in-memory data structure store). Use this link https://redis.io/topics/quickstart to download and start redis server.