package com.w2a.APITestingFramework.API;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.w2a.APITestingFramework.setUp.BaseTest;

import io.restassured.response.Response;

public class CreateCustomerAPI extends BaseTest {

	public static Response sendPostRequestToCreateCustomerWithValidSecretKey(Hashtable<String, String> data) {
//sample comment
		Response response = given().auth().basic(config.getProperty("vaildSecretKey"), "")
				.formParam("email", data.get("email")).formParam("description", data.get("description"))
				.post(config.getProperty("customerAPIEndpoint"));

		return response;

	}

	public static Response sendPostRequestToCreateCustomerWithinvalidSecretKey(Hashtable<String, String> data) {

		Response response = given().auth().basic(config.getProperty("invalidSecretKey"), "")
				.formParam("email", data.get("email")).formParam("description", data.get("description"))
				.post(config.getProperty("customerAPIEndpoint"));
		return response;

	}

}
