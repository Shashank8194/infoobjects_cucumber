package cucumber.dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    public Properties properties;
    public final String propertyFilePath = "C://Users//Info_DS//Downloads//testng-cucumber//src//test//resources//configuration.properties";


    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }
    public String username()
    {
        String username=properties.getProperty("username");
        if (username != null)
        {
            return  username;
        }
        else  throw  new  RuntimeException("user is not defined");
    }

    public String password()
    {
        String password=properties.getProperty("password");

        if (password!=null)
        {
            return password;
        }
        else throw new RuntimeException("password is not defined");
    }
    public  String authorization_endpoint()
    {
        String auth_endpoint=properties.getProperty("auth_endpoint");
        if (auth_endpoint!=null)
        {
            return auth_endpoint;
        }
        else
            throw  new RuntimeException("endpoint is not specified");
    }
    public  String oData_global_endpoint()
    {
        String oData_global_endpoint=properties.getProperty("oData_global_endpoint");
        if (oData_global_endpoint!=null)
        {
            return oData_global_endpoint;
        }
        else
            throw  new RuntimeException("oData_global_endpoint is not specified");
    }
}
