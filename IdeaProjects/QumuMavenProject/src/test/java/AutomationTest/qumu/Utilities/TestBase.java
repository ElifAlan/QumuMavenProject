package AutomationTest.qumu.Utilities;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.BeforeClass;

public class TestBase {

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI=TestDataReader.get("api_url");
    }
}
