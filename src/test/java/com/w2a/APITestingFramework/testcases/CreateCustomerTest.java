package com.w2a.APITestingFramework.testcases;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.APITestingFramework.API.CreateCustomerAPI;
import com.w2a.APITestingFramework.listeners.ExtentListeners;
import com.w2a.APITestingFramework.setUp.BaseTest;
import com.w2a.APITestingFramework.utilities.dataUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;
public class CreateCustomerTest extends BaseTest{
	
	@Test(dataProviderClass = dataUtil.class, dataProvider="data")
	public void validateCreateCustomerAPIWithValidKey(Hashtable<String,String> data) {
	
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerWithValidSecretKey(data);
		ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(dataProviderClass = dataUtil.class, dataProvider="data")
	public void validateCreateCustomerAPIWithInvalidKey(Hashtable<String,String> data) {
		
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerWithinvalidSecretKey(data);
		ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
}
