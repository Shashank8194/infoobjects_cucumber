package utilities;

import cucumber.dataProvider.ConfigFileReader;
import io.restassured.response.Response;

public class Commons {
   private String Base_URI;
   private String End_Point;
    String Entity;
    ConfigFileReader configFileReader=new ConfigFileReader();
    Response response;


    public String generate_request_url()
    {
        Base_URI=(configFileReader.Base_URI());
        if (Base_URI!=null)
        {
            return Base_URI;
        }
        else throw  new  RuntimeException("Base URL is not specified in the configuration file");
    }

    public  String getEnd_Point()
    {
        End_Point=(configFileReader.end_point());
        if (End_Point!=null)
        {
            return End_Point;
        }
        else throw new RuntimeException("End point is not specified");
    }

    public Integer Status_code()
    {
         int status_code=response.getStatusCode();
         if (status_code==200)
         {
            System.out.println(status_code);
            return  status_code;
         }
         else throw new RuntimeException(String.valueOf(status_code));
    }

}
