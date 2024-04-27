package org.example.Steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.example.apiUtils.RestAssuredExtension;

public class S5_RemoveCandidateAPI {
    private static ResponseOptions<Response> response ;

//    @Given("User Got all Data using {string}")
//    public void user_got_all_data_using(String url , DataTable dataTable) {
//        RestAssuredExtension.setHeader(dataTable.cell(1,1).toString(),dataTable.cell(1,2).toString());
//        response = RestAssuredExtension.getRequest(url);
//        response.getBody().prettyPrint();
//        System.out.println(response.toString());
//        System.out.println(response.getBody());
////        JSONPObject data = new JSONPObject(response
//    }
    @When("User Delete candidate using")
    public void user_delete_candidate_using() {

    }
    @Then("Assert User Removed Successfully using {string}")
    public void assert_user_removed_successfully_using(String string) {

    }
}
