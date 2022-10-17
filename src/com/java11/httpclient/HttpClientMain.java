package com.java11.httpclient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class HttpClientMain {

	private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder().build();
	private static final int TIMEOUT = 3;
	private static final int TIMEOUT_FIFTEEN = 15;
	private static final Duration DURATION_TIMEOUT = Duration.ofSeconds(TIMEOUT);
	private static final String SOCKET_IP = "186.148.172.110";
	private static final int SOCKET_PORT = 8181;
	private static final Duration DURATION_TIMEOUT_FIFTEEN_SECONDS = Duration.ofSeconds(TIMEOUT_FIFTEEN);

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
		System.out.println(" --------------ASYNC--------------- ");
		
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

		try {
			httpClient6.sendAsync(request6, BodyHandlers.ofString())
					.thenApply(HttpResponse::body)
					.thenAccept(System.out::println)
					.get(TIMEOUT, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}

		addRepeatedTexts();
		System.out.println(" --------------POST--------------- ");
		
		HttpClient httpClient7 = HttpClient.newBuilder()
				.connectTimeout(DURATION_TIMEOUT)
				.followRedirects(Redirect.NORMAL)
				.build();

		HttpRequest request7 = HttpRequest.newBuilder()
				.POST(BodyPublishers.ofString("{\"name\":\"Leonardo Narciso\"}"))
				.uri(URI.create("https://www.postman-echo.com/post"))
				.header("accept", "application/xml")
				.timeout(DURATION_TIMEOUT)
				.build();

		HttpResponse<String> response7 = httpClient7.send(request7, BodyHandlers.ofString());

		System.out.println("Response headers: " + response7.headers());
		System.out.println("Response code: " + response7.statusCode());
		System.out.println("Response body: " + response7.body());
		
		addRepeatedTexts();
		System.out.println(" --------------PROXY-------------- ");
		
		HttpClient httpClient8 = HttpClient.newBuilder()
				.connectTimeout(DURATION_TIMEOUT_FIFTEEN_SECONDS)
				//.proxy(ProxySelector.of(new InetSocketAddress(SOCKET_IP, SOCKET_PORT)))
				.followRedirects(Redirect.NORMAL)
				.build();

		HttpRequest request8 = HttpRequest.newBuilder()
				.POST(BodyPublishers.ofString("{\"name\":\"Leonardo Narciso\"}"))
				.uri(URI.create("https://www.postman-echo.com/post"))
				.header("accept", "application/xml")
				.timeout(DURATION_TIMEOUT_FIFTEEN_SECONDS)
				.build();

		try {
			httpClient8.sendAsync(request8, BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
			.thenAccept(System.out::println)
			.get(TIMEOUT_FIFTEEN, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
