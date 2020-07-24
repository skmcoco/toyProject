package phonePractice;

public class MyPhoneInfo {
	private String PhoneNumber;
	private String name;
	private String relation;
	private String birthday;
	
	public MyPhoneInfo(String phoneNumber, String name, String relation, String birthday) {
		this.PhoneNumber = phoneNumber;
		this.name = name;
		this.relation = relation;
		this.birthday = birthday;
	}
	
	public MyPhoneInfo(String phoneNumber, String name) {
		PhoneNumber = phoneNumber;
		this.name = name;
	}
	
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void showInfo() {
		System.out.println("번호=" + PhoneNumber + ", 이름=" + name + ", 관계=" + relation + ", 생일="
				+ birthday);
	}
	
}
