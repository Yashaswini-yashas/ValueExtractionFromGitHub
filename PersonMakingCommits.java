import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

import io.restassured.path.json.JsonPath;

public class PersonMakingCommits {
	public static void main(String args[]) {
		String username = "Yashaswini-yashas";
		String password = "Pe1@Ac2H";
		String url = "https://api.github.com/repos/Yashaswini-yashas/ValueExtractionFromJIRA/commits";
		
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
	             //System.out.print(result.length());
	             JsonPath js = new JsonPath(result);
//people who made the change to the code or added new code to the Repository          
	             String committer = js.getString("commit.committer.name");
	             //committer = committer.replaceAll(",", "\n");
	             //System.out.println(committer);
	             
//commit messages	             
	             String commit_message = js.getString("commit.message");
	             //commit_message=commit_message.replaceAll(",", "\n");
	    	    // System.out.println("The Commit messages for this Repository are"+" "+":"+" "+commit_message);                
	             
//time at which commit was made
	             String commit_time = js.getString("commit.committer.date");
	             System.out.println(committer+" : "+"\n"+commit_message+" : "+"\n"+commit_time); 
	             
	     }      
	     catch (IOException e)
	     {   System.out.print("error");
	         e.printStackTrace();
	     }
	     
	}
}