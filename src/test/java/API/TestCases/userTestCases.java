package API.TestCases;

import API.EndPoints.endPoints;
import API.payLoads.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class userTestCases {

    Faker fake;
    User payLoads;

    @BeforeClass
    public void setUpData(){
        fake = new Faker();
        payLoads = new User();
        payLoads.setId(fake.idNumber().hashCode());
        payLoads.setUsername(fake.name().username());
        payLoads.setFirstname(fake.name().firstName());
        payLoads.setLastname(fake.name().lastName());
        payLoads.setEmail(fake.internet().emailAddress());
        payLoads.setPhone(fake.phoneNumber().cellPhone());
        payLoads.setUserStatus(0);
    }

    @Test(priority = 1)
    public void testPostUser(){
        Response response = endPoints.createUser(payLoads);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 2)
    public void testGetUser(){
        Response response = endPoints.getUser(this.payLoads.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 3)
    public void testUpdateUser(){
        payLoads.setFirstname(fake.name().firstName());
        payLoads.setLastname(fake.name().lastName());
        payLoads.setEmail(fake.internet().emailAddress());

        Response res = endPoints.updateUser(this.payLoads.getUsername(),payLoads);
        res.then().log().all();
        Assert.assertEquals(res.getStatusCode(),200);
//        Validating post update

        Response res1 = endPoints.getUser(this.payLoads.getUsername());
        Assert.assertEquals(res1.getStatusCode(),200);
    }

    @Test(priority = 4)
    public void testDeleteUser(){
        Response res = endPoints.deleteUser(this.payLoads.getUsername());
        res.then().log().all();
        Assert.assertEquals(res.getStatusCode(),200);
    }
}
