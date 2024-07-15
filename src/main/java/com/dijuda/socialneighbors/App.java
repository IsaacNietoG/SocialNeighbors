package com.dijuda.socialneighbors;

import com.dijuda.socialneighbors.api.Session;

import java.net.HttpRetryException;
import java.net.URI;
import java.net.http.*;

public class App {
  public static void main(String[] args) {
    
    Session session = new Session();

    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("192.168.0.15:8000/saludar")).method("GET", HttpRequest.BodyPublishers.noBody()).build();
    HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println(response.body());
  } 
}
