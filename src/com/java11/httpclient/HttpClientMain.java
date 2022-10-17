package com.java11.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class HttpClientMain {

	private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder().build();
	private static final Duration DURATION_TIMEOUT = Duration.ofSeconds(3);

	public static void main(String... args) throws IOException, InterruptedException {
		addRepeatedTexts();
		System.out.println(" ------------HTTPCLIENT----------- ");

		HttpRequest request = HttpRequest
				.newBuilder()
				.GET()
				.uri(URI.create("https://www.google.com/"))
				.build();

		HttpResponse<String> response = HTTP_CLIENT.send(request, BodyHandlers.ofString());

		System.out.println("Response headers: " + response.headers());
		System.out.println("Response code: " + response.statusCode());
		System.out.println("Response body: " + response.body());

		addRepeatedTexts();
		System.out.println(" --------------XML---------------- ");

		HttpRequest request2 = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create("https://apichallenges.herokuapp.com/todos"))
				.header("accept", "application/xml")
				.build();

		HttpResponse<String> response2 = HTTP_CLIENT.send(request2, BodyHandlers.ofString());

		System.out.println("Response headers: " + response2.headers());
		System.out.println("Response code: " + response2.statusCode());
		System.out.println("Response body: " + response2.body());

		

		addRepeatedTexts();
		System.out.println(" --------DURATION--TIMEOUT-------- ");

		HttpClient httpClient4 = HttpClient.newBuilder()
				.connectTimeout(DURATION_TIMEOUT)
				.build();

		HttpRequest request4 = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create("https://www.getpostman.com/"))
				.header("accept", "application/xml")
				.timeout(DURATION_TIMEOUT)
				.build();

		HttpResponse<String> response4 = httpClient4.send(request4, BodyHandlers.ofString());

		System.out.println("Response headers: " + response4.headers());
		System.out.println("Response code: " + response4.statusCode());
		System.out.println("Response body: " + response4.body());
		
		
		addRepeatedTexts();
		System.out.println(" -----------REDIRECT-------------- ");
		
		HttpClient httpClient5 = HttpClient.newBuilder()
				.connectTimeout(DURATION_TIMEOUT)
				.followRedirects(Redirect.NORMAL)
				.build();

		HttpRequest request5 = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create("https://www.getpostman.com/"))
				.header("accept", "application/xml")
				.timeout(DURATION_TIMEOUT)
				.build();

		HttpResponse<String> response5 = httpClient5.send(request5, BodyHandlers.ofString());

		System.out.println("Response headers: " + response5.headers());
		System.out.println("Response code: " + response5.statusCode());
		System.out.println("Response body: " + response5.body());
		
		addRepeatedTexts();
		System.out.println(" --------------POST--------------- ");
		
		HttpClient httpClient6 = HttpClient.newBuilder()
				.connectTimeout(DURATION_TIMEOUT)
				.followRedirects(Redirect.NORMAL)
				.build();

		HttpRequest request6 = HttpRequest.newBuilder()
				.POST(BodyPublishers.ofString("{\"name\":\"Leonardo Narciso\"}"))
				.uri(URI.create("https://www.postman-echo.com/post"))
				.header("accept", "application/xml")
				.timeout(DURATION_TIMEOUT)
				.build();

		HttpResponse<String> response6 = httpClient6.send(request6, BodyHandlers.ofString());

		System.out.println("Response headers: " + response6.headers());
		System.out.println("Response code: " + response6.statusCode());
		System.out.println("Response body: " + response6.body());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		addRepeatedTexts();
		System.out.println(" --------RESPONSE--TIMEOUT-------- ");

		HttpRequest request3 = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create("https://cat-fact.herokuapp.com/facts/"))
				.header("accept", "application/xml")
				.timeout(DURATION_TIMEOUT)
				.build();

		HTTP_CLIENT.send(request3, BodyHandlers.ofString());
	}
	
	private static void addRepeatedTexts() {
		System.out.println();
		System.out.println();
		System.out.println(" --------------------------------- ");
	}

}
