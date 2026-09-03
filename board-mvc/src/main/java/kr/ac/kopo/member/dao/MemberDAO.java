package kr.ac.kopo.member.dao;

import java.util.List;

import kr.ac.kopo.member.vo.MemberVO;

public interface MemberDAO {
	
	/**
	 * 전체 회원 리스트
	 */
	List<MemberVO> selectAll();
	
	/**
	 *  새 회원 가입
	 */
	void insert(MemberVO member);
	/**
	 * 로그인
	 */
	MemberVO login(MemberVO loginVO);
	
}
