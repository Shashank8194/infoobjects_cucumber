package utilities;

import cucumber.dataProvider.ConfigFileReader;
import io.restassured.RestAssured;

import javax.management.openmbean.CompositeData;

public class Commons {
    String Base_URI;
    String End_Point;
    String Entity;
    ConfigFileReader configFileReader=new ConfigFileReader();



    public String generate_request_url()
    {
        Base_URI=(configFileReader.Base_URI());

        End_Point=(configFileReader.end_point());

        if (End_Point=="/odata")
        {
            Base_URI=Base_URI+End_Point;
            return  Base_URI;
        }
        else
        {
            throw  new RuntimeException("end point is not specified");
        }

    }

}
