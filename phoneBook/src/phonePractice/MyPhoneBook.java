package phonePractice;

import java.util.Scanner;

public class MyPhoneBook {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void menu() {
		System.out.println("반갑습니다. 전화번호부 입니다");
		System.out.println("선택하십시오(ArrayList기반)");
		System.out.println("1. 등록");
		System.out.println("2. 전체 조회");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
	}
	
	public static void menu2() {
		System.out.println("안녕하세요. To-do List 입니다.");
		System.out.println("선택하십시오 (MAP 기반)");
		System.out.println("1. 조회");
		System.out.println("2. 전체조회");		
		System.out.println("3. 등록");
		System.out.println("4. 수정");
		System.out.println("5. 삭제");
	}
	
	public static void PhoneBookMain() {
		
		MyPhoneBookManager mbpm = new MyPhoneBookManager();
		
		while(true) {
			
			menu();
			int num = sc.nextInt();
			
			switch (num) {
			case 1:
				mbpm.inputPhoneInfo();
				break;
			case 2: 
				mbpm.selectPhoneAllInfo();
				break;
			case 3: 
				mbpm.selectPhoneInfo();
				break;
			case 4:
				mbpm.removeBook();
				break;
			default :
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
	
	public static void todoListMain() {
		
		MyTodoListManager manager = new MyTodoListManager();
		
		while(true) {
				
				menu2();
				int num = sc.nextInt();
				
				switch (num) {
				case 1:
					System.out.println("조회");
					break;
				case 2: 
					System.out.println("전체 조회");
					break;
				case 3: 
					manager.insertTodo();
					break;
				case 4:
					System.out.println("수정");
					break;
				case 5:
					System.out.println("삭제");
					break;
				default :
					System.out.println("프로그램을 종료합니다.");
					return;
				}
			}
	}
	
	public static void main(String[] args) {
		
		System.out.println("안녕하세요");
		System.out.println("전화번호부는 1번, To_do List는 2번 눌러주세요");
		
		int num = sc.nextInt();
		
		switch (num) {
		case 1 :
			PhoneBookMain();
			break;
		case 2 :
			todoListMain();
			break;
		default:
			break;
		}
		
	}
}
