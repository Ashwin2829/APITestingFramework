package com.w2a.APITestingFramework.API;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.w2a.APITestingFramework.setUp.BaseTest;

import io.restassured.response.Response;

public class DeleteCustomerAPI extends BaseTest {

	public static Response sendDeleteRequestToDeleteCustomerWithValidID(Hashtable<String, String> data) {

		Response response = given().auth().basic(config.getProperty("vaildSecretKey"), "")
				.delete(config.getProperty("customerAPIEndpoint")+"/"+data.get("id"));

		return response;

	}

}
