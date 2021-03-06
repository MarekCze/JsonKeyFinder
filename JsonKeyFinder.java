import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonKeyFinder {
    
    // keys are typed directly into method call as a comma separated list of Strings
    public Map<String,Object> parseElement(JsonElement jsonElement, String... keys){
        
        Map<String, Object> values = new HashMap<String, Object>();
        // check if element is a JsonObject
        if(jsonElement.isJsonObject()){
            // convert element to JsonObject
            JsonObject jsonObject = (JsonObject) jsonElement;
            // iterate through list of keys
            for(String key : keys){
                
                if(jsonObject.has(key)){
                    
                    if(!jsonObject.get(key).isJsonPrimitive()){
                        /*if object has key & is not a primitive
                        recursively call parseElement, passing in
                        the current key and list of all keys
                        */
                        parseElement(jsonObject.get(key),values,keys);
                        
                    } else {
                        // if object is primitive, add to values array                       
                        values.put(key,checkType(jsonObject.get(key)));
                        
                    }
                }
            }
            // if element is a JsonArray
        } else if(jsonElement.isJsonArray()){
            // convert element to JsonArray
            JsonArray jsonArray = (JsonArray) jsonElement;
            // iterate through all elements inside JsonArray
            for(JsonElement jo : jsonArray){
                /* recursively call parseElement, passing in
                current object and list of all keys
                */
                
                parseElement(jo,values,keys);
                
            }            
        }
        
        return values;
        
    }
    
    // takes a list of String keys as argument
    public Map<String,Object> parseElement(JsonElement jsonElement, List<String> keys){
        
        Map<String, Object> values = new HashMap<String, Object>();
        
        if(jsonElement.isJsonObject()){

            JsonObject jsonObject = (JsonObject) jsonElement;

            for(String key : keys){
                
                if(jsonObject.has(key)){
                    
                    if(!jsonObject.get(key).isJsonPrimitive()){
                        
                        parseElement(jsonObject.get(key),values,keys);
                        
                    } else {    
                        
                        values.put(key,checkType(jsonObject.get(key)));
                        
                    }
                }
            }
        } else if(jsonElement.isJsonArray()){

            JsonArray jsonArray = (JsonArray) jsonElement;

            for(JsonElement jo : jsonArray){
                
                parseElement(jo,values,keys);
                
            }            
        }
        
        return values;
        
    }

    // keys are typed directly into method call as a comma separated list of Strings
    private Map<String, Object> parseElement(JsonElement jsonElement, Map<String, Object> values, String... keys){
        
        if(jsonElement.isJsonObject()){

            JsonObject jsonObject = (JsonObject) jsonElement;

            for(String key : keys){
                
                if(jsonObject.has(key)){
                    
                    if(!jsonObject.get(key).isJsonPrimitive()){
                        
                        parseElement(jsonObject.get(key),values,keys);   
                        
                    } else {
                        
                        values.put(key, checkType(jsonObject.get(key)));
                        
                    }
                }
            }
            
        } else if(jsonElement.isJsonArray()){

            JsonArray jsonArray = (JsonArray) jsonElement;

            for(JsonElement jo : jsonArray){
                
                parseElement(jo,values,keys);
                
            }            
        }
        
        return values;
        
    }
    
    // takes a list of String keys as argument
    private Map<String, Object> parseElement(JsonElement jsonElement, Map<String, Object> values, List<String> keys){

        if(jsonElement.isJsonObject()){

            JsonObject jsonObject = (JsonObject) jsonElement;

            for(String key : keys){
                
                if(jsonObject.has(key)){
                    
                    if(!jsonObject.get(key).isJsonPrimitive()){

                        parseElement(jsonObject.get(key),values,keys);                   
                    } else {

                        values.put(key, checkType(jsonObject.get(key)));
                    }
                }
            }

        } else if(jsonElement.isJsonArray()){

            JsonArray jsonArray = (JsonArray) jsonElement;

            for(JsonElement jo : jsonArray){

                parseElement(jo,values,keys);
                
            }            
        }
        
        return values;
        
    }
    
    // check type of primitive json value
    private Object checkType(JsonElement jsonElement){
        
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElement;
        
        if(jsonPrimitive.isBoolean()){
            
            return jsonPrimitive.getAsBoolean();
            
        } else if(jsonPrimitive.isNumber()){
            
            return jsonPrimitive.getAsDouble();
            
        }
        
        return jsonPrimitive.getAsString();
        
    }
     
}