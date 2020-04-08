import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;

import io.restassured.path.json.JsonPath;

public class Created {
	
public static void main(String args[]) {
	String username = "USERNAME";
	String password = "PASSWORD";
	String url = "https://api.github.com/repos/Yashaswini-yashas/ValueExtractionFromJIRA";
	
	String[] command = {"curl", "-u", username+":"+password , url};
	 ProcessBuilder process = new ProcessBuilder(command); 
     Process p;
     try
     {
         p = process.start();
          BufferedReader reader =  new BufferedReader(new InputStreamReader(p.getInputStream()));
             StringBuilder builder = new StringBuilder();
             String line = null;
             while ( (line = reader.readLine()) != null) {
                     builder.append(line);
                     builder.append(System.getProperty("line.separator"));
             }
             String result = builder.toString();
            //System.out.print(result);
             JsonPath js = new JsonPath(result);
 // repository created at             
             String created = js.get("created_at");
    	     System.out.println("repository creation date and time"+" "+":"+" "+created);
// last updation on the repository
    	     String updated = js.get("updated_at");
    	     System.out.println("last updation on the repository"+" "+":"+" "+updated);
    	               
     }
     catch (IOException e)
     {   System.out.print("error");
         e.printStackTrace();
     }
     
}
}
