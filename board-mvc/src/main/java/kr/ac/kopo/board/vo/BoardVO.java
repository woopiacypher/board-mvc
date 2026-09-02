package kr.ac.kopo.board.vo;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;

public class BoardVO {

	/** 번호 */
	private int no;
	/** 제목 */
	@Length(min = 2, max = 50, message = "최소2글자이상 입력해주세요")
	@NotEmpty(message = "필수항목입니다")
	private String title;
	/** 작성자 */
	@NotEmpty(message = "필수항목입니다")
	private String writer;
	/** 내용 */
	@NotEmpty(message = "필수항목입니다")
	private String content;
	/** 조회수 */
	private int viewCnt;
	/** 등록일 */
	private String regDate;
	
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BoardVO(int no, String title, String writer, String regDate) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.regDate = regDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", viewCnt="
				+ viewCnt + ", regDate=" + regDate + "]";
	}
	
	
}
