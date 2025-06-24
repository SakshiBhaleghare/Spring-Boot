package com.ThirdPartyAPICall;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.Entity.User;

@RestController
public class WebClientCall {

	@GetMapping("/getSynCall")
	public String getSynCall() {

		System.out.println("Synchronuos-call-started");

		String url = "https://jsonplaceholder.typicode.com/posts";

		WebClient webClient = WebClient.create();

		String result = webClient.get().uri(url).retrieve().bodyToMono(String.class).block();

		System.out.println(result);

		System.out.println("Synchronuos-call-end");

		return result;
	}

	@GetMapping("/getAsynCall")
	public void getAsynCall() {

		System.out.println("Asynchronuos-call-started");

		String url = "https://jsonplaceholder.typicode.com/posts";

		WebClient webClient = WebClient.create();

		webClient.get().uri(url).retrieve().bodyToMono(String.class).subscribe(WebClientCall::requestHandler);

		System.out.println("Asynchronuos-call-end");

	}

	private static String requestHandler(String response) {

		System.out.println(response);

		return response;
	}

	@PostMapping("/postCall")
	public String postCall(@RequestBody User user) {

		String url = "http://localhost:8005/exponent/adduser";

		WebClient webClient = WebClient.create();

		String result = webClient.post().uri(url).bodyValue(user).retrieve().bodyToMono(String.class).block();

		System.out.println(result);

		return result;

	}

	@DeleteMapping("/deleteCall")
	public String deleteCall(@RequestParam("uid") int id) {

		String url = "http://localhost:8005/exponent/deleteUser?uid=" + id;

		WebClient webClient = WebClient.create();

		String result = webClient.delete().uri(url).retrieve().bodyToMono(String.class).block();

		System.out.println(result);

		return result;

	}

}
