import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NoOfCommits {
	public static void main(String args[]) {
		String username = "USERNAME";
		String password = "PASSWORD";
		String url = "https://api.github.com/repos/Yashaswini-yashas/{REPO_NAME}/stats/contributors";
		
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
	             System.out.print(result);
	     }
	     catch (IOException e)
	     {   System.out.print("error");
	         e.printStackTrace();
	     }
	     
	}
}
