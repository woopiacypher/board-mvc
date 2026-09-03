package kr.ac.kopo.member.service;

import java.util.List;

import kr.ac.kopo.member.vo.MemberVO;

public interface MemberService {
	
	// 전체 맴버 리스트
	List<MemberVO> getMemberList() throws Exception;
	// 맴버 추가
	void addNewMember(MemberVO member) throws Exception;
	// 마이페이지
	MemberVO getMemberByMyPage(int memberNo) throws Exception;
	// 로그 인
	MemberVO checkMember(MemberVO member);
}
