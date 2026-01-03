package API.EndPoints;

import API.payLoads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class endPoints {
//    The endpoints class is used to get the every type of requests as methods.

    public static Response createUser(User payLoads){
        Response res = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payLoads)

                .when()
                .post(Routines.postUrl);
        return res;
    }

    public static Response getUser(String userName){
        Response res = given()
                .accept(ContentType.JSON)
                .pathParam("username",userName)

                .when()
//                .get("https://petstore.swagger.io/v2/user/{username}");
                .get(Routines.getUrl);
        return res;

    }

    public static Response updateUser(String userName,User payLoads){
        Response res = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",userName)
                .body(payLoads)

                .when()
                .put(Routines.putUrl);

        return res;

    }

    public static Response deleteUser(String userName ){
        Response res = given()
                .contentType(ContentType.JSON)
                .pathParam("username",userName)

                .when()
                .delete(Routines.deleteUrl);

        return res;
    }
}
