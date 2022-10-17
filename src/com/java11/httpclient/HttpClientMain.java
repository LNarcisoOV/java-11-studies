package com.java11.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class HttpClientMain {

	private static final HttpClient httpClient = HttpClient.newBuilder().build();
	
	public static void main(String... args) throws IOException, InterruptedException {
		
		System.out.println(" --------------------------------- ");
		System.out.println(" ------------HTTPCLIENT----------- ");
		
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create("https://www.google.com/"))
				.build();
		
		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
		
		System.out.println("Response code: " + response.statusCode() );
		System.out.println("Response body: " + response.body());
		
		
		System.out.println();
		System.out.println();
		System.out.println(" --------------------------------- ");
		System.out.println(" --------------XML---------------- ");
		
		
		HttpRequest request2 = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create("https://apichallenges.herokuapp.com/todos"))
				.header("accept", "application/xml")
				.build();
		
		HttpResponse<String> response2 = httpClient.send(request2, BodyHandlers.ofString());
		
		System.out.println("Response code: " + response2.statusCode() );
		System.out.println("Response body: " + response2.body());
	
		System.out.println(" --------------------------------- ");
		System.out.println(" --------------------------------- ");
		
		
		System.out.println();
		System.out.println();
		System.out.println(" --------------------------------- ");
		System.out.println(" -------------TIMEOUT------------- ");
		
		
		HttpRequest request3 = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create("https://cat-fact.herokuapp.com/facts/"))
				.header("accept", "application/xml")
				.timeout(Duration.ofSeconds(3))
				.build();
		
		HttpResponse<String> response3 = httpClient.send(request3, BodyHandlers.ofString());
		
		System.out.println("Response code: " + response3.statusCode() );
		System.out.println("Response body: " + response3.body());
	
		System.out.println(" --------------------------------- ");
		System.out.println(" --------------------------------- ");
	}

}
