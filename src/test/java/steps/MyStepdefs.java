package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.tutorialController;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Endpoints;
import utils.JsonInputParser;

import static io.restassured.RestAssured.given;

public class MyStepdefs {
    int userID;

    tutorialController user, user1, responseUser;

    Response response, putresponse;

    ObjectMapper objectMapper = new ObjectMapper();
    JsonPath jsonPath;
    JSONObject testData;

    @BeforeTest
    public void beforeTest() {
        RestAssured.baseURI = "http://localhost:8080/api/tutorials";
    }

    @Given("user details")
    public void userDetails() {
        testData = (JSONObject) JsonInputParser.data.get("createRequest");
    }

    @When("creating a user")
    public void creatingAUser() throws JsonProcessingException {
        testData = (JSONObject) JsonInputParser.data.get("createRequest");
        user = new tutorialController((String) testData.get("title"),
                (String) testData.get("description"),
                (Boolean) testData.get("published"));

        response = given()
                .body(user)
                .when().post(Endpoints.tutorialEndpoint)
                .then()
                .statusCode(201).extract().response();
        objectMapper = new ObjectMapper();
        responseUser = objectMapper.readValue(response.asString(), tutorialController.class);
    }


    @Then("user must be created")
    public void userMustBeCreated() throws JsonProcessingException {
        responseUser = objectMapper.readValue(response.asString(), tutorialController.class);
        Assert.assertEquals(user.getTitle(), responseUser.getTitle());

    }

    @And("updating user")
    public void updatingUser() throws JsonProcessingException {
        responseUser = objectMapper.readValue(response.asString(), tutorialController.class);
        Assert.assertEquals(user.getTitle(), responseUser.getTitle());

    }

    @Then("user got updated")
    public void userGotUpdated() throws JsonProcessingException {
        responseUser = objectMapper.readValue(response.asString(), tutorialController.class);
        Assert.assertEquals(user.getTitle(), responseUser.getTitle());
    }

    @Then("user got deleted")
    public void userGotDeleted() throws JsonProcessingException {
        responseUser = objectMapper.readValue(response.asString(), tutorialController.class);
        Assert.assertEquals(user.getTitle(), responseUser.getTitle());
    }

    @Then("user description gets updated")
    public void userDescriptionGetsUpdated() throws JsonProcessingException {
        responseUser = objectMapper.readValue(response.asString(), tutorialController.class);
        Assert.assertEquals(user.getTitle(), responseUser.getTitle());
    }

    @When("creating without title")
    public void creatingWithoutTitle() throws JsonProcessingException {
        testData = (JSONObject) JsonInputParser.data.get("createRequest");
        user = new tutorialController((String) testData.get("title"),
                (String) testData.get("description"),
                (Boolean) testData.get("published"));

        response = given()
                .body(user)
                .when().post(Endpoints.tutorialEndpoint)
                .then()
                .statusCode(201).extract().response();
        objectMapper = new ObjectMapper();
        responseUser = objectMapper.readValue(response.asString(), tutorialController.class);
    }


    @Then("error shown")
    public void errorShown() throws JsonProcessingException {
        responseUser = objectMapper.readValue(response.asString(), tutorialController.class);
        Assert.assertEquals(user.getDescription(), responseUser.getDescription());
    }

    @When("creating with title")
    public void creatingWithTitle() throws JsonProcessingException {
        testData = (JSONObject) JsonInputParser.data.get("createRequest");
        user = new tutorialController((String) testData.get("title"),
                (String) testData.get("description"),
                (Boolean) testData.get("published"));

        response = given()
                .body(user)
                .when().post(Endpoints.tutorialEndpoint)
                .then()
                .statusCode(201).extract().response();
        objectMapper = new ObjectMapper();
        responseUser = objectMapper.readValue(response.asString(), tutorialController.class);
    }

    @Then("title should be test")
    public void titleShouldBeTest() throws JsonProcessingException {
        responseUser = objectMapper.readValue(response.asString(), tutorialController.class);
        Assert.assertEquals(user.getTitle(), responseUser.getTitle());
    }


    tutorialController user2, responseUser1;
    JSONObject testData1;
    Response response1;

    @Given("details")
    public void details() {
        testData1 = (JSONObject) JsonInputParser.data.get("putRequest");
    }

    @When("modifying details")
    public void modifyingDetails() throws JsonProcessingException {
        testData1 = (JSONObject) JsonInputParser.data.get("putRequest");
        user2 = new tutorialController((String) testData1.get("title1"),
                (String) testData1.get("description1"),
                (Boolean) testData1.get("published1"));

        response1 = given()
                .body(user2)
                .when().post(Endpoints.tutorialEndpoint)
                .then()
                .statusCode(201).extract().response();

        objectMapper = new ObjectMapper();
        responseUser1 = objectMapper.readValue(response1.asString(), tutorialController.class);
    }

    @Then("error thrown")
    public void errorThrown() throws JsonProcessingException{
        responseUser = objectMapper.readValue(response1.asString(), tutorialController.class);
        Assert.assertEquals(user2.getTitle1(), responseUser.getTitle1());
    }

    tutorialController user3, responseUser3;
    JSONObject testData2;
    Response response3;

    @Given("details1")
    public void details1() {
        testData2 = (JSONObject) JsonInputParser.data.get("putRequest1");
    }
    @When("creating description")
    public void creatingDescription() throws JsonProcessingException {
        testData2 = (JSONObject) JsonInputParser.data.get("putRequest1");
        user3 = new tutorialController((String) testData2.get("title2"),
                (String) testData2.get("description2"),
                (Boolean) testData2.get("published2"));

        response3 = given()
                .body(user3)
                .when().post(Endpoints.tutorialEndpoint)
                .then()
                .statusCode(201).extract().response();

        objectMapper = new ObjectMapper();
        responseUser3 = objectMapper.readValue(response3.asString(), tutorialController.class);
    }
    @Then("description gets updated")
    public void descriptionGetsUpdated() throws JsonProcessingException {
        responseUser3 = objectMapper.readValue(response3.asString(), tutorialController.class);
        Assert.assertEquals(user3.getDescription2(), responseUser3.getDescription2());
    }

    tutorialController user4, responseUser4;
    JSONObject testData3;
    Response response4;

    @Given("test details")
    public void testDetails() throws JsonProcessingException{
        testData3 = (JSONObject) JsonInputParser.data.get("putRequest2");
    }

    @When("creating id with alphanumeric char")
    public void creatingIdWithAlphanumericChar() throws JsonProcessingException{
        testData3 = (JSONObject) JsonInputParser.data.get("putRequest2");
        user4 = new tutorialController((String) testData3.get("title3"),
                (String) testData3.get("description3"),
                (Boolean) testData3.get("published3"));

        response4 = given()
                .body(user4)
                .when().post(Endpoints.tutorialEndpoint)
                .then()
                .statusCode(201).extract().response();

        objectMapper = new ObjectMapper();
        responseUser4 = objectMapper.readValue(response4.asString(), tutorialController.class);
    }

    @Then("error is shown")
    public void errorIsShown() throws JsonProcessingException {
        responseUser4 = objectMapper.readValue(response4.asString(), tutorialController.class);
        Assert.assertEquals(user4.getPublished3(), responseUser4.getPublished3());
    }

}

