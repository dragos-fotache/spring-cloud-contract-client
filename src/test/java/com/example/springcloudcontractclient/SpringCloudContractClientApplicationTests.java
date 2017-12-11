package com.example.springcloudcontractclient;

import static io.restassured.RestAssured.get;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.response.Response;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureStubRunner(ids = {"com.test:spring-cloud-contract:+:stubs:8888"}, workOffline = true)
public class SpringCloudContractClientApplicationTests {

	@Test
	public void test() {
		
		Response response = get("http://localhost:8889/greeting");
		
		String responseStr = response.getBody().asString();
		
		assertEquals("Got: Hello worlds!", responseStr);
		
		
	}

}
