package com.helper;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.basepage.BasePage;
import com.constraint.EndPoints;
import com.fasterxml.jackson.core.type.TypeReference;
import com.pojo.MySelf;
import com.pojo.TechnicalSkills;
import com.utilities.ExtentReportConf;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class MySelfHelper extends BasePage {

	Response response;
	ValidatableResponse valResponse;

	public ValidatableResponse getAll() {
		response = given().spec(get(EndPoints.ALL_PERSON)).when().get();
		ExtentReportConf.reportInfoLog(response.asString());
		valResponse = response.then().spec(getResponse());
		response.then().body("[0].title", equalTo("myself"));
		return valResponse;

	}

	public List<MySelf> getAllMyself() {

		Response response = given().log().all().when().get(EndPoints.ALL_PERSON).andReturn();

		Type type = new TypeReference<List<MySelf>>() {

		}.getType();

		List<MySelf> myselfList = response.as(type);
		ExtentReportConf.reportInfoLog(response.asString());

		// assertEquals(myselfList.get(0).getAuthor(), "shanawaz mansuri");
		// assertEquals(myselfList.get(0).getTitle(), "myself");
		return myselfList;
	}

	public ValidatableResponse postTest() {

		MySelf ms = new MySelf();
		List<String> al = new ArrayList<String>();
		al.add("BitBucket");
		al.add("Git");
		/*
		 * TechnicalSkills ts = new TechnicalSkills(); ts.setSourceCode("Bamboo");
		 * ts.setDefectTool("Bugzilla"); ts.setProgammingLanguage("C#");
		 * 
		 * ms.setId(5); ms.setTitle("Sweet Family"); ms.setAuthor("All Family");
		 * ms.setPrimarySkills(al); ms.setTechnical(al);
		 */

		response = given().spec(post(EndPoints.CREATE_PERSON, ms)).when().post();
		ExtentReportConf.reportInfoLog(response.asString());
		valResponse = response.then().spec(postResponse());
		return valResponse;
	}

	public ValidatableResponse putTest() {

		MySelf ms = new MySelf();
		List<String> al = new ArrayList<String>();
		al.add("BitBucket");
		al.add("Git");
		TechnicalSkills ts = new TechnicalSkills();
		/*
		 * ts.setSourceCode("Bamboo"); ts.setDefectTool("Bugzilla");
		 * 
		 * ms.setId(2); ms.setTitle("Smart Family"); ms.setAuthor("Mansuri");
		 * ms.setPrimarySkills(al); ms.setTechnical(al);
		 */

		response = given().spec(update(EndPoints.UPDATE_PERSON, ms, 2)).when().put();
		ExtentReportConf.reportInfoLog(response.asString());
		valResponse = response.then().spec(updateResponse());
		return valResponse;
	}

	public ValidatableResponse delete() {

		response = given().spec(delete(EndPoints.DELETE_PERSON, 5)).when().delete();
		ExtentReportConf.reportInfoLog(response.asString());
		valResponse = response.then().spec(deleteResponse());
		return valResponse;

	}
	/*
	 * public ValidatableResponse params() { Map<String, Object> map = new
	 * HashMap<String, Object>(); map.put("Author", "Mansuri");
	 * 
	 * response = given().spec(getQueryParam(EndPoints.ALL_PERSON,
	 * map)).when().get(); ExtentReportConf.reportInfoLog(response.asString());
	 * valResponse = response.then().spec(getResponse()); return valResponse;
	 * 
	 * }
	 * 
	 * public ValidatableResponse path() { Map<String, Object> map = new
	 * HashMap<String, Object>(); map.put("id", 2);
	 * 
	 * response = given().spec(getPathparam(EndPoints.ALL_PERSON,
	 * map)).when().get(); ExtentReportConf.reportInfoLog(response.asString());
	 * valResponse = response.then().spec(getResponse()); return valResponse;
	 * 
	 * }
	 */
}