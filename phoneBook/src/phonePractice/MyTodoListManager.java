package phonePractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyTodoListManager {
	
	public static Scanner sc = new Scanner(System.in);
	static MyTodoListInfo info = new MyTodoListInfo();
	
	public void insertTodo() {
		System.out.println("우선순위와, 내용을 입력해 주십시오. ex) 우선순위, 내용");
		
		List<Map<String, String>> maplist = new ArrayList<Map<String, String>>();
		
		Map<String, String> map = new HashMap<>();
		
		String[] insertList = {"우선순위", "내용"};
		
		String str = "";
		String str1 = "";
		
		for (String name : insertList) {
			System.out.print(name + " :");
			if (name == "우선순위") {
				str = sc.nextLine();
			} else {
				str1 = sc.nextLine();
			}
			map.put(str, str1);
			info.setPriorityAndContent(map); 
		}
		
		

		maplist.add(map);
		
	}
}
