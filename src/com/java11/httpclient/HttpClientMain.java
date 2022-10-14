package com.java11.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpClientMain {
	
	public static void main(String... args) throws IOException, InterruptedException {
		HttpClient httpClient = HttpClient.newBuilder().build();
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://www.google.com/"))
				.GET()
				.build();
		
		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
		
		System.out.println("Response code: " + response.statusCode() + ",\n body: " + response.body());
	}

}
