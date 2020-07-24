package phonePractice;

import java.util.ArrayList;
import java.util.Scanner;

public class MyPhoneBookManager {

	ArrayList<MyPhoneInfo> phoneBook = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	FileCreator fc = new FileCreator();
	
	public void inputPhoneInfo() {

		String[] nameList = { "전화번호: ", "이름 : ", "관계 : ", "생년월일 : " };
		ArrayList<String> dataList = new ArrayList<>();
		String data = "";

		for (String name : nameList) {
			System.out.print(name);
			data = sc.nextLine();
			dataList.add(data);
		}

		phoneBook.add(new MyPhoneInfo(dataList.get(0), dataList.get(1), dataList.get(2), dataList.get(3)));
	}

	public void selectPhoneInfo() {

		int index;

		System.out.println("이름을 입력해주십시오");

		String name = sc.nextLine();

		index = search(name);

		if (index < 0) {
			System.out.println("등록된 이름이 없습니다.");
		} else {
			phoneBook.get(index).showInfo();
			System.out.println("데이터검색 완료\n");
		}
	}

	private int search(String name) {

		for (int index = 0; index < phoneBook.size(); index++) {
			if (name.compareTo(phoneBook.get(index).getName()) == 0) {
				return index;
			}
		}
		return -1;
	}

	public void removeBook() {
		int index;
		System.out.print("삭제할 이름 입력:");
		String name = sc.nextLine();
		index = search(name);
		if (index < 0)
			System.out.println("해당하는 값이 없습니다.");
		else {
			phoneBook.remove(index);
			System.out.println("데이터삭제 완료\n");
		}
	}

	public void selectPhoneAllInfo() {

		for (int i = 0; i < phoneBook.size(); i++) {
			phoneBook.get(i).showInfo();
		}

		System.out.println("엑셀 파일 생성하시겠습니까?(Y/N)");
		String yn = sc.nextLine();

		if ("Y".equals(yn.toUpperCase())) {
			fc.excelCreator(phoneBook);
		} else {
			System.out.println("N");
		}
	}

	
}