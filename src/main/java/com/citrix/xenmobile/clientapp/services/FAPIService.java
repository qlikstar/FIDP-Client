package com.citrix.xenmobile.clientapp.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FAPIService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${client.id}")
    private String clientId;

    @Value("${client.secret}")
    private String clientSecret;

    @Value("${fapi.server.fqdn}")
    private String fAPIServerFQDN;

    RestTemplate restTemplate = new RestTemplate();

    public Object makeRestCall(String uri, HttpMethod httpMethod, HttpEntity entity) {

        try {

            Object result = restTemplate.exchange(fAPIServerFQDN + uri, httpMethod, entity, Object.class);

            return result;

        } catch (Exception e) {
            logger.error("URL : " + fAPIServerFQDN + uri + "  HTTP Method : " + httpMethod + "  Entities : " + entity.toString() + " : " + e.getMessage());
            logger.error("Exception occurred ", e);
            return new Error(e.getMessage(),e.getCause());
        }
    }
}
