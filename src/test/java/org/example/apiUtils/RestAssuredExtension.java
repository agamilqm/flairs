package org.example.apiUtils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.util.Map;
import java.util.Objects;

public class RestAssuredExtension {
    private static RequestSpecification request ;
    public RestAssuredExtension(){
        RequestSpecification requestSpec = new RequestSpecBuilder().
                setContentType(ContentType.JSON).build();
        request = RestAssured.given().spec(requestSpec);
    }

    public static void setBaseUrl(String url){
        request.baseUri(url);
    }

    public static void setHeader (String headerName , String headerValue){
        Header header = new Header(headerName,headerValue);
        request.header(header);
    }

    public static ResponseOptions<Response> getRequest(String url){
        request.body("");
        return request.get(url);
    }
    public static ResponseOptions<Response> postRequest (String url , Map<String, Object> body){
        request.body(body);
        return request.post(url);
    }
    public static ResponseOptions<Response> deleteRequestWithPathParam (String url , String pathParam){
        return request.delete(url+"/"+pathParam);
    }
    public static ResponseOptions<Response> deleteRequestWithBody (String url , Map<String , Object>body){
        return request.delete(url,body);
    }
}
