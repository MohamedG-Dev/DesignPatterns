package org.learning.designPatterns;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class BaseTest {
    private WebDriver driver;

    public WebDriver initializeDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    public List<HashMap<String,String>> getJsonData(String filepath){
        ObjectMapper mapper = new ObjectMapper();
        try(InputStream input = getClass().getClassLoader().getResourceAsStream(filepath)){
            if(input==null){
                throw new RuntimeException("Unable to find data/testData.json");
            }
            return mapper.readValue(input,new TypeReference<List<HashMap<String,String>>>(){});
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
    public List<HashMap<String,String>> getJsonData1(String filepath) {
        ObjectMapper mapper = new ObjectMapper();

        // Debug: This prints the actual folder the ClassLoader is searching
        System.out.println("ClassLoader is searching in: " + getClass().getClassLoader().getResource("."));

        try (InputStream input = getClass().getClassLoader().getResourceAsStream(filepath)) {
            if (input == null) {
                // Updated error message to show exactly what path failed
                throw new RuntimeException("Resource not found at: " + filepath);
            }
            return mapper.readValue(input, new TypeReference<List<HashMap<String, String>>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error parsing JSON file: " + filepath, e);
        }
    }
}
