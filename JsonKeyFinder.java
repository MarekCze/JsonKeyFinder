import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class JsonKeyFinder {
    public List<Object> parseElement(JsonElement jsonElement, List<String> keys, List<Object> values){
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
                        parseElement(jsonObject.get(key), keys, values);                    
                    } else {
                        // if object is primitive, call getKey
                        values.add(jsonObject.get(key));
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
                parseElement(jo, keys, values);
            }            
        }
        
        return values;
    }
    
    // this method can be modified to suit your needs
    public void getKey(JsonElement jsonElement){
        //print out key (primitive)
        System.out.println(jsonElement);
    }
}