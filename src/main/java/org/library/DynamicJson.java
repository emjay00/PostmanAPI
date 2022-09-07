package org.library;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {
    @Test(dataProvider = "Booksdata")
    public void AddBook() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all().header("Content-type", "application/json").
                body(Payload.AddBook()).
                when()
                .post("Library/Addbook.php")
                .then().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath js = Reusable.rawToJson(response);
        String id = js.get("ID");
        System.out.println(id);

    }

    //Dataprovider if you want to send data from here or from external file
    @DataProvider(name = "Booksdata")
    public Object[][] getdata() {
        return new Object[][]{
                {"random1", "123"}, {"random2", "3445"}, {"random3", "234"}
        };
    }
}
