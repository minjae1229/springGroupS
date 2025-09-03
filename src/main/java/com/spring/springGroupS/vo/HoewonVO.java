package com.spring.springGroupS.vo;

import lombok.Data;

/*
* @Getter@Setter@ToString
* @AllArgsConstructor
* @NoArgsConstructor
* @Builder
*/
@Data // Getter,Setter,toString을 모두 포함하지만 spring boot에서 생성자 주입방식을 쓸 경우 문제 발생.
public class HoewonVO {
	private String mid;
	private String pwd;
	private String name;
	private String gender;
	private int age;
	
	//3번 예제에서 사용
	private String nickName; 
	private String strGender;
	
	/*
	 * public String getMid() { return mid; } public void setMid(String mid) {
	 * this.mid = mid; } public String getPwd() { return pwd; } public void
	 * setPwd(String pwd) { this.pwd = pwd; } public String getName() { return name;
	 * } public void setName(String name) { this.name = name; } public String
	 * getGender() { return gender; } public void setGender(String gender) {
	 * this.gender = gender; } public int getAge() { return age; } public void
	 * setAge(int age) { this.age = age; }
	 * 
	 * @Override public String toString() { return "HoewonVO [mid=" + mid + ", pwd="
	 * + pwd + ", name=" + name + ", gender=" + gender + ", age=" + age + "]"; }
	 */
}
