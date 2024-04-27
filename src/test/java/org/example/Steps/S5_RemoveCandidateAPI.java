package org.example.Steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.example.apiUtils.RestAssuredExtension;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class S5_RemoveCandidateAPI {
    private static ResponseOptions<Response> response ;
    Integer totalResultBeforeDelete ;

    @Given("user Got all Data using {string}")
    public void user_got_all_data_using(String url , DataTable dataTable) {
        RestAssuredExtension.setHeader(dataTable.cell(0,0).toString(),dataTable.cell(0,1).toString());
        response = RestAssuredExtension.getRequest(url);

        System.out.println(response.body().path("meta").toString());
        JsonPath jsonData = new JsonPath(response.body().asPrettyString());
        HashMap<String,Integer> total = jsonData.get("meta");
        totalResultBeforeDelete = total.get("total");
        System.out.println("Total Result of Candidates is "+totalResultBeforeDelete);
    }
    @When("User Delete candidate using {string}")
    public void user_delete_candidate_using(String url) {
        String jsonAsString =  "{\n" +
                "    \"ids\": [\n" +
                "        2\n" +
                "    ]\n" +
                "}";

        Map<String,Object> dataAsMap = new JsonPath(jsonAsString).getMap("");

        response= RestAssuredExtension.deleteRequestWithBody(url,dataAsMap);
        response.body().prettyPrint();
    }
    @Then("Assert User Removed Successfully using {string}")
    public void assert_user_removed_successfully_using(String url) {
        Integer totalResultAfterCreate = totalResultBeforeDelete-1;
        response = RestAssuredExtension.getRequest(url);
        JsonPath jsonData = new JsonPath(response.body().asPrettyString());
        HashMap<String,Integer> total = jsonData.get("meta");
        Assert.assertEquals(totalResultAfterCreate,total.get("total"));
    }
}
