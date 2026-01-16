package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class JSONDataReader {
    public List<HashMap<String,String>> readData(){
        File file = new File("./src/test/resources/data/testData.json");
        try {
            String jsonContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List< HashMap<String, String>>>() {
            });
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //The below code is more optimized version of readData method
    public List<HashMap<String,String>> getJsonData(){
        ObjectMapper mapper = new ObjectMapper();
        try(InputStream input = getClass().getClassLoader().getResourceAsStream("data/testData.json")){
            if(input==null){
                throw new RuntimeException("Unable to find data/testData.json");
            }
            return mapper.readValue(input,new TypeReference<List<HashMap<String,String>>>(){});
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
}
