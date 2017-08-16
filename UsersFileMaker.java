package coding;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * המחלקה ממירה קובץ json מפורמט אחד ויוצרת בפורמט אחר, על הססמאות מפעילים hashcode
 * (תשובה ל1)
 *
 */
public class UsersFileMaker {
    public static void main(String[] args) {
		try {
			JSONParser parser = new JSONParser();// אובייקט שממיר טקסטים בקבצים לאובייקטים
			JSONObject output = new JSONObject(); // אובייקט שנשתמש בו בשביל לשמור את הנתונים לפלט
			JSONArray usersArray = new JSONArray(); // מערך שנשמור בו את המשתמשים
			JSONArray inputData = (JSONArray) parser.parse(new FileReader("src/coding/j.json")); // מערך הקלט
			for (int i = 0; i < inputData.size(); i++) { // רצים על הקלט
				JSONObject user = (JSONObject) inputData.get(i); // שומרים משתמש ממערך הקלט
				usersArray.add(user.get("username").toString()+":"+user.get("password").toString().hashCode()); // מוסיפים למערך המשתמשים את שם המשתמש ונקודותיים ואת ההאשקוד של הססמה
			}
			output.put("users", usersArray); // שמים בפלט שדה בשם יוזרז ובו מערך המשתמשים
			try (FileWriter file = new FileWriter("src/coding/users.txt")) { // פותחים קובץ לכתיבה
				file.write(output.toJSONString()); // שמים את הפלט בקובץ
			}
			System.out.println("\nJSON Object: " + output); // מדפיסים מה הפלט
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
    }
}

/*
תיקנו הזחות
שינינו משתנה בשם loopindex לi
שינינו משתנה איקס לאאוטפוט
שינינו משתנה וואי ליוזראריי
שינינו זד לאינפוטדאטה

z:
[
	{
		"username": "natalie",
		"password": 6548
	},
	{
		"username": "noam",
		"password": 65467
	},
	{
		"username": "yosi",
		"password": 65464
	},
	{
		"username": "shlomo",
		"password": 6546321
	}
]

y:
["natalie:1661315","noam:51500758","yosi:51500755","shlomo:-2047381359"]

x:

{"users":["natalie:1661315","noam:51500758","yosi:51500755","shlomo:-2047381359"]}
*/