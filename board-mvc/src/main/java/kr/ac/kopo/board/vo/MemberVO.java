package kr.ac.kopo.board.vo;

import jakarta.validation.constraints.NotEmpty;

public class MemberVO {
	
	public MemberVO() {
		super();
	}
	public MemberVO(String id, String pwd, String name, String email, String regDate) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.regDate = regDate;
	}
	
	@NotEmpty(message = "필수 항목입니다.")
	private String id;
	@NotEmpty(message = "필수 항목입니다.")
	private String pwd;
	@NotEmpty(message = "필수 항목입니다.")
	private String name;
	@NotEmpty(message = "필수 항목입니다.")
	private String email;
	private String regDate;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
}
