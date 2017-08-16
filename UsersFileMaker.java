package coding;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * ������ ����� ���� json ������ ��� ������ ������ ���, �� ������� ������� hashcode
 * (����� �1)
 *
 */
public class UsersFileMaker {
    public static void main(String[] args) {
		try {
			JSONParser parser = new JSONParser();// ������� ����� ������ ������ ����������
			JSONObject output = new JSONObject(); // ������� ������ �� ����� ����� �� ������� ����
			JSONArray usersArray = new JSONArray(); // ���� ������ �� �� ��������
			JSONArray inputData = (JSONArray) parser.parse(new FileReader("src/coding/j.json")); // ���� ����
			for (int i = 0; i < inputData.size(); i++) { // ���� �� ����
				JSONObject user = (JSONObject) inputData.get(i); // ������ ����� ����� ����
				usersArray.add(user.get("username").toString()+":"+user.get("password").toString().hashCode()); // ������� ����� �������� �� �� ������ ���������� ��� ������� �� �����
			}
			output.put("users", usersArray); // ���� ���� ��� ��� ����� ��� ���� ��������
			try (FileWriter file = new FileWriter("src/coding/users.txt")) { // ������ ���� ������
				file.write(output.toJSONString()); // ���� �� ���� �����
			}
			System.out.println("\nJSON Object: " + output); // ������� �� ����
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
    }
}

/*
����� �����
������ ����� ��� loopindex �i
������ ����� ���� ��������
������ ����� ���� ���������
������ �� �����������

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