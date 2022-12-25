package ex01;

import java.sql.Date;

/**
 * member 테이블의 레코드(record)를 표현하는 VO(Value Object) 클래스
 */
public class MemberVO {
	// 필드(fields): member 테이블의 레코드에서 각 컬럼(column)을 표현
	private int id;
	private String account;
	private String passwd;
	private String name;
	private String email;
	private Date regdate;

	// 메서드(methods)
	// → 프레임워크 등에서 자동화를 하기 위해, VO 클래스 또는 DTO 클래스에는 모든 필드를
	//   초기화하는 생성자, 기본 생성자, 설정자, 접근자를 정의해야 한다.
	public MemberVO(int id, String account, String passwd, String name, String email, Date regdate) {
		this.id = id;
		this.account = account;
		this.passwd = passwd;
		this.name = name;
		this.email = email;
		this.regdate = regdate;
	}

	public MemberVO() {
		this(0, null, null, null, null, null);
	}

	public int getId() {
		return id;
	}

	public String getAccount() {
		return account;
	}

	public String getPasswd() {
		return passwd;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
