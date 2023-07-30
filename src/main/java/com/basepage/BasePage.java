package com.basepage;

import static io.restassured.RestAssured.baseURI;

import java.net.MalformedURLException;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.constraint.EndPoints;
import com.pojo.MySelf;
import com.utilities.ExtentReportConf;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;

public class BasePage {

	public RequestSpecification reqspec;
	public ResponseSpecification resspec;
	public String path = System.getProperty("user.dir");
	public String className = this.getClass().getSimpleName();

	@BeforeClass
	public void setUp() throws MalformedURLException {

		baseURI = EndPoints.BASE_URI;
		ExtentReportConf.reportSetUp(className);
		ExtentReportConf.reportInfoLog("Test Started");
	}

	@AfterClass
	public void tearDown() {

		ExtentReportConf.reportInfoLog("Test Completed Successfully");
		ExtentReportConf.reportTearDown();
	}

	public RequestSpecification get(String endPoint) {

		reqspec = new RequestSpecBuilder().setBasePath(endPoint).setContentType(ContentType.JSON).build();
		return reqspec;
	}

	public RequestSpecification getSingle(String endPoint, int id) {

		reqspec = new RequestSpecBuilder().setBasePath(endPoint).addPathParam("id", id).setContentType(ContentType.JSON)
				.build();
		return reqspec;
	}

	public RequestSpecification getWithToken(String endPoint, String token) {

		given().basePath(endPoint).auth().oauth2(token);
		return reqspec;
	}

	public RequestSpecification getWithUserPwd(String endPoint, String userName, String pwd) {

		given().basePath(endPoint).auth().basic(userName, pwd);
		return reqspec;
	}

	public RequestSpecification post(String endPoint, MySelf body) {

		given().basePath(endPoint).contentType(ContentType.JSON).when().body(body);
		return reqspec;
	}

	public RequestSpecification postWithToken(String endPoint, String body, String token) {

		given().basePath(endPoint).auth().oauth2(token).contentType(ContentType.JSON).when().body(body);
		return reqspec;
	}

	public RequestSpecification postWithUserPwd(String endPoint, String body, String userName, String pwd) {

		given().basePath(endPoint).auth().basic(userName, pwd).contentType(ContentType.JSON).when().body(body);
		return reqspec;
	}

	////

	public RequestSpecification update(String endPoint, MySelf body, int id) {

		given().basePath(endPoint).pathParam("id", id).contentType(ContentType.JSON).when().body(body);
		return reqspec;
	}

	public RequestSpecification updateWithToken(String endPoint, String body, String token) {

		given().basePath(endPoint).auth().oauth2(token).contentType(ContentType.JSON).when().body(body);
		return reqspec;
	}

	public RequestSpecification updateWithUserPwd(String endPoint, String body, String userName, String pwd) {

		given().basePath(endPoint).auth().basic(userName, pwd).contentType(ContentType.JSON).when().body(body);
		return reqspec;
	}

	public RequestSpecification delete(String endPoint, int id) {

		given().baseUri(EndPoints.BASE_URI).basePath(endPoint).pathParam("id", id);
		return reqspec;
	}

	public ResponseSpecification getResponse() {

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectStatusLine("HTTP/1.1 200 OK")
				.expectContentType(ContentType.JSON).expectResponseTime(Matchers.lessThan(2000L)).log(LogDetail.ALL)
				.build();
		return resspec;
	}

	public ResponseSpecification postResponse() {

		resspec = new ResponseSpecBuilder().expectStatusCode(201).expectStatusLine("HTTP/1.1 201 Created")
				.expectContentType(ContentType.JSON).expectResponseTime(Matchers.lessThan(2000L)).log(LogDetail.ALL)
				.build();
		return resspec;
	}

	public ResponseSpecification updateResponse() {

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectStatusLine("HTTP/1.1 200 OK")
				.expectContentType(ContentType.JSON).expectResponseTime(Matchers.lessThan(2000L)).log(LogDetail.ALL)
				.build();
		return resspec;
	}

	public ResponseSpecification deleteResponse() {

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectStatusLine("HTTP/1.1 200 OK")
				.expectContentType(ContentType.JSON).expectResponseTime(Matchers.lessThan(2000L)).log(LogDetail.ALL)
				.build();
		return resspec;
	}

	public ResponseSpecification getPathparam(String endPoint, Map<String, Object> map) {

		reqspec = new RequestSpecBuilder().setBasePath(endPoint).addPathParams(map).setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON).log(LogDetail.ALL).build();
		return resspec;
	}

	public ResponseSpecification getQueryParam(String endPoint, Map<String, Object> map) {

		reqspec = new RequestSpecBuilder().setBasePath(endPoint).addQueryParams(map).setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON).log(LogDetail.ALL).build();
		return resspec;
	}

}
