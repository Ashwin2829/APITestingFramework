package com.w2a.APITestingFramework.testcases;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.APITestingFramework.API.CreateCustomerAPI;
import com.w2a.APITestingFramework.API.DeleteCustomerAPI;
import com.w2a.APITestingFramework.listeners.ExtentListeners;
import com.w2a.APITestingFramework.setUp.BaseTest;
import com.w2a.APITestingFramework.utilities.TestUtil;
import com.w2a.APITestingFramework.utilities.dataUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;
public class DeleteCustomerTest extends BaseTest{
	
	@Test(dataProviderClass = dataUtil.class, dataProvider="data")
	public void deleteCustomer(Hashtable<String,String> data) {
	
		Response response = DeleteCustomerAPI.sendDeleteRequestToDeleteCustomerWithValidID(data);
		
		response.prettyPrint();
		ExtentListeners.testReport.get().info(data.toString());
		/*System.out.println(response.getStatusCode());
		
		String actualid = response.jsonPath().get("id").toString();
		Assert.assertEquals(actualid, data.get("id"),"ID did not match");*/
		
		System.out.println("Presence check for object key "+TestUtil.jsonHasKey(response.asString(), "object"));
		System.out.println("Presence check for deleted key "+TestUtil.jsonHasKey(response.asString(), "deleted"));
		Assert.assertTrue(TestUtil.jsonHasKey(response.asString(), "id"));
		String actualid = TestUtil.getJsonKeyValue(response.asString(), "id");
		Assert.assertEquals(actualid, data.get("id"),"ID did not match");
		System.out.println("Object key value is "+TestUtil.getJsonKeyValue(response.asString(), "object"));
		System.out.println("Deleted key value is "+TestUtil.getJsonKeyValue(response.asString(), "deleted"));
	}
	

	
}
