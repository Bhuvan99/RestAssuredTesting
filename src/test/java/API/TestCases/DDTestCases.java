package API.TestCases;

import API.EndPoints.endPoints;
import API.Utlility.dataProviders;
import API.payLoads.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DDTestCases {

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = dataProviders.class)
    public void testPostUsers(String UserID, String UserName,String FirstName, String LastName, String Email, String Password, String Phone){

        User payload = new User();
        payload.setId(Integer.parseInt(UserID));
        payload.setUsername(UserName);
        payload.setFirstname(FirstName);
        payload.setLastname(LastName);
        payload.setEmail(Email);
        payload.setPassword(Password);
        payload.setPhone(Phone);

        Response res = endPoints.createUser(payload);
        res.then().log().all();
        Assert.assertEquals(res.getStatusCode(),200);
    }

    @Test(priority = 2,dataProvider = "UserNames", dataProviderClass = dataProviders.class)
    public void testGetUser(String UserName){
        Response response = endPoints.getUser(UserName);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }


}
