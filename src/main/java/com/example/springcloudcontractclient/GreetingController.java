package com.example.springcloudcontractclient;

import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@RestController
public class GreetingController {

	@GetMapping("greeting")
	public String greeting() throws IOException {
		Request request = new Request.Builder().url("http://localhost:8888/greeting").build();

		OkHttpClient client = new OkHttpClient();
		Response response = client.newCall(request).execute();
		
		BufferedReader br = new BufferedReader(response.body().charStream());

		StringBuffer result = new StringBuffer();
		
		String line = br.readLine();
		
		while (line != null) {
			result.append(line);
			line = br.readLine();
		}
		
		return "Got: " + result;

	}

}
