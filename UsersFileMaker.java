package coding;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//  json - replace formats
// hashcode on passwords
public class UsersFileMaker {
    public static void main(String[] args) {
    	Runtime rt = Runtime.getRuntime();
    	
    	long[] times = new long[1000];
    	
    	for(int execNum=1; execNum<1000; execNum++) {
    	
	    	long startTime = System.currentTimeMillis();
	    	
			try {
				JSONParser parser = new JSONParser();// texts to objects
				JSONObject output = new JSONObject(); 
				JSONArray usersArray = new JSONArray();
				JSONArray inputData = (JSONArray) parser.parse(new FileReader("src/coding/j.json"));
				for (int i = 0; i < inputData.size(); i++) { // input
					JSONObject user = (JSONObject) inputData.get(i); // 
					usersArray.add(user.get("username").toString()+":"+user.get("password").toString().hashCode()); // add user and password to array
				}
				output.put("users", usersArray); // users field and users
				try (FileWriter file = new FileWriter("src/coding/users.txt")) { // output in a file
					file.write(output.toJSONString()); // print output
				}
				System.out.println("\nJSON Object: " + output); // print output
				
				System.out.println("totalMemory = "+ rt.totalMemory()/1024 + "KB");
				//System.out.println(rt.freeMemory());
		    	
				// check used memory in KB
				//System.gc();
				//long usedKB = (rt.totalMemory() - rt.freeMemory()) / 1024;
			   // System.out.println("used memory = " + usedKB + "KB");
	
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
			long elapsedTime = System.currentTimeMillis()-startTime;
			times[execNum] = elapsedTime;
    	}		
		System.out.println(Arrays.toString(times));
		//System.out.println("Time = " + elapsedTime + "ms");
    }
}
 