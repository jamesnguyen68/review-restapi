package com.dummy.rest.stock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;


import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.dummy.rest.stock.entity.dummy.DummyEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/dummy/")
@Slf4j
public class DummyController {

   


    @GetMapping(value="/java8")
    public String getMethodName() throws IOException {
        // httpUrlConnection ( old version )
        String url = "https://jsonplaceholder.typicode.com/posts";

        URL myURL = new URL(url);
        // Make connection
        HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
        // What MEHOD USE (POST GET PUT DELETE)
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(3000);
        connection.setReadTimeout(3000);
        
        // GET HTTP STATUS
        int httpStatus = connection.getResponseCode();

        log.info("=======================");
        log.info(httpStatus+"");
        BufferedReader reader;
        StringBuffer  responseContent = new StringBuffer();
        String line;
        // if(httpStatus==200){

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while((line = reader.readLine()) != null){
                responseContent.append(line);
            }

            reader.close();
        // }

        // HttpClient 11

            // responseContent.toString() => GSON => OBJECT


        return responseContent.toString();
    }

    

    @GetMapping(value="/javaspring")
    public Flux<DummyEntity> getallwithspring() {
        log.info("========== getallwithspring ===");
        WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com");
        return webClient.get().uri("/posts").retrieve().bodyToFlux(DummyEntity.class);
    }
    
    
    @GetMapping(value="/java11")
    public String getwithjava11() {
       
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/posts")).build();

        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenApply(HttpResponse::body)
        // .thenApply(DummyEntity::printOut)
        .thenAccept(System.out::println)
        .join();
        return "java 11";
    }
    
    public String printOut(DummyEntity s){
        return s.toString();
    }
}


