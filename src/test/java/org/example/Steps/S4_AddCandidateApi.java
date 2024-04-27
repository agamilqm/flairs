package org.example.Steps;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonParser;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.example.apiUtils.RestAssuredExtension;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S4_AddCandidateApi {
    private static ResponseOptions<Response> response ;
    Integer totalResultBeforeCreate ;
    @Given("User Got all Data using {string}")
    public void user_got_all_data_using(String url, DataTable dataTable) {
        RestAssuredExtension.setHeader(dataTable.cell(0,0).toString(),dataTable.cell(0,1).toString());
        response = RestAssuredExtension.getRequest(url);

        System.out.println(response.body().path("meta").toString());
        JsonPath jsonData = new JsonPath(response.body().asPrettyString());
        HashMap<String,Integer> total = jsonData.get("meta");
        totalResultBeforeCreate = total.get("total");
        System.out.println("Total Result of Candidates is "+totalResultBeforeCreate);

    }
    @When("User Adding new candidates using {string}")
    public void user_adding_new_candidates_using(String url) {

        String jsonAsString =  "{\n" +
                "    \"firstName\": \"test\",\n" +
                "    \"middleName\": \"api\",\n" +
                "    \"lastName\": \"now\",\n" +
                "    \"email\": \"test@anything.com\",\n" +
                "    \"contactNumber\": \"0022333445566\",\n" +
                "    \"keywords\": \"noidea,test\",\n" +
                "    \"comment\": \"no  notes\",\n" +
                "    \"dateOfApplication\": \"2024-04-27\",\n" +
                "    \"consentToKeepData\": true \n" +
                "}";

        Map<String,Object> dataAsMap = new JsonPath(jsonAsString).getMap("");

        response= RestAssuredExtension.postRequest(url,dataAsMap);
        response.body().prettyPrint();

    }
    @Then("Assert User Added Successfully using {string}")
    public void assert_user_added_successfully_using(String url) {
        Integer totalResultAfterCreate = totalResultBeforeCreate+1;
        response = RestAssuredExtension.getRequest(url);
        JsonPath jsonData = new JsonPath(response.body().asPrettyString());
        HashMap<String,Integer> total = jsonData.get("meta");
        Assert.assertEquals(totalResultAfterCreate,total.get("total"));
    }

}
