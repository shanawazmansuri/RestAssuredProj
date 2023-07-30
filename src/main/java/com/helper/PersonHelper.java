/*
 * package com.helper;
 * 
 * import static io.restassured.RestAssured.given; import static
 * org.hamcrest.Matchers.equalTo;
 * 
 * import java.lang.reflect.Type; import java.util.ArrayList; import
 * java.util.HashMap; import java.util.List; import java.util.Map;
 * 
 * import com.basepage.BasePage; import com.constraint.EndPoints; import
 * com.fasterxml.jackson.core.type.TypeReference; import com.pojo.MySelf; import
 * com.pojo.Person; import com.pojo.TechnicalSkills; import
 * com.utilities.ExtentReportConf;
 * 
 * import io.restassured.response.Response; import
 * io.restassured.response.ValidatableResponse;
 * 
 * public class PersonHelper extends BasePage {
 * 
 * private String id; private String title; private String author; Person
 * person; Response response; ValidatableResponse valResponse;
 * 
 * public PersonHelper(String id, String title, String author) { this.id = id;
 * this.title = title; this.author = author;
 * 
 * }
 * 
 * public PersonHelper() {
 * 
 * }
 * 
 * 
 * 
 * public List<Person> getAllPerson() {
 * 
 * Response response =
 * given().log().all().when().get(EndPoints.ALL_PERSON).andReturn();
 * 
 * Type type = new TypeReference<List<Person>>() {
 * 
 * }.getType();
 * 
 * List<Person> personList = response.as(type);
 * ExtentReportConf.reportInfoLog(response.asString());
 * 
 * // assertEquals(myselfList.get(0).getAuthor(), "shanawaz mansuri"); //
 * assertEquals(myselfList.get(0).getTitle(), "myself"); return personList; }
 * 
 * public void singlePerson() {
 * 
 * 
 * response = given().spec(getSingle(EndPoints.SINGLE_PERSON, 8)).when().get();
 * ExtentReportConf.reportInfoLog(response.asString()); valResponse =
 * response.then().spec(getResponse()); }
 * 
 * public void allPersons() {
 * 
 * 
 * try { response = given().spec(getSingle(EndPoints.SINGLE_PERSON,
 * 8)).when().get(); ExtentReportConf.reportInfoLog(response.asString());
 * valResponse = response.then().spec(getResponse().body("title[0]",
 * equalTo("json-server")));
 * ExtentReportConf.reportInfoLog(response.asString()); } catch (Exception e) {
 * // TODO Auto-generated catch block ExtentReportConf.
 * reportFailLogwithSS("Error occured while executing and details are "+response
 * .asString(), author); }
 * 
 * }
 * 
 * public void postPerson() {
 * 
 * person = new Person(); /*Person.setId(29); Person.setTitle("Ahmed");
 * Person.setAuthor("Ahmedi");
 * 
 * response = given().spec(Post(EndPoints.CREATE_PERSON, person)).when().post();
 * ValidatableResponse valResponse = response.then().spec(postResponse());
 * ExtentReportConf.reportInfoLog(response.asString());
 * 
 * }
 * 
 * public void test4() { Map<String, Object> map = new HashMap<String,
 * Object>(); map.put("Author", "Aisha"); map.put("Id", "4");
 * 
 * 
 * response = given().spec(getQueryParam(EndPoints.ALL_PERSON,
 * map)).when().get(); ExtentReportConf.reportInfoLog(response.asString());
 * valResponse = response.then().spec(getResponse()); return valResponse;
 * 
 * 
 * }
 * 
 * public ValidatableResponse test5() { person = new Person();
 * Person.setId(Integer.parseInt(id)); Person.setTitle(title);
 * Person.setAuthor(author);
 * 
 * 
 * ValidatableResponse response = given().spec(Post(EndPoints.CREATE_PERSON,
 * person)).when().post(); ValidatableResponse valResponse =
 * response.then().spec(postResponse());
 * ExtentReportConf.reportInfoLog(response.asString());
 * 
 * 
 * return valResponse;
 * 
 * }
 * 
 * public ValidatableResponse put() { person = new Person();
 * 
 * Person.setId(30); Person.setTitle("Pop"); Person.setAuthor("Pops");
 * 
 * 
 * 
 * ValidatableResponse response = given().spec(Post(EndPoints.UPDATE_PERSON,
 * person,29)).when().put(); ValidatableResponse valResponse =
 * response.then().spec(updateResponse());
 * ExtentReportConf.reportInfoLog(response.asString());
 * 
 * 
 * return valResponse;
 * 
 * }
 * 
 * public ValidatableResponse patch() { person = new Person();
 * 
 * Person.setTitle("Home"); Person.setAuthor("Homes");
 * 
 * 
 * ValidatableResponse response = given().spec(update(EndPoints.UPDATE_PERSON,
 * person,29)).when().put(); ValidatableResponse valResponse =
 * response.then().spec(updateResponse());
 * ExtentReportConf.reportInfoLog(response.asString());
 * 
 * return valResponse;
 * 
 * }
 * 
 * public ValidatableResponse delete() {
 * 
 * response = given().spec(delete(EndPoints.DELETE_PERSON, 5)).when().delete();
 * ExtentReportConf.reportInfoLog(response.asString()); valResponse =
 * response.then().spec(deleteResponse()); return valResponse;
 * 
 * }
 * 
 * }
 */