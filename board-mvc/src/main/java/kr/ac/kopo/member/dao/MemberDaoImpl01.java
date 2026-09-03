package kr.ac.kopo.member.dao;

import kr.ac.kopo.mapper.MemberMapper;
import kr.ac.kopo.member.vo.MemberVO;

public class MemberDaoImpl01 implements MemberDAO {

	private MemberMapper memberMapper;
	
	public void MemberDaoImpl(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}
	
	@Override
	public MemberVO login(MemberVO loginVO) {
		return memberMapper.login(loginVO);
	}

}
