package kr.ac.kopo.member.service;

import java.util.List;

import kr.ac.kopo.member.vo.MemberVO;

public interface MemberService {
	
	// 전체 맴버 리스트
	List<MemberVO> getMemberList() throws Exception;
	// 맴버 추가
	void join(MemberVO member) throws Exception;
	// 마이페이지
	MemberVO getMemberByMyPage(String memberNo) throws Exception;
	// 로그 인
	MemberVO checkMember(MemberVO member);
	/** 아이디 중복 확인 */
	boolean isDuplicateId(String id) throws Exception;
}
