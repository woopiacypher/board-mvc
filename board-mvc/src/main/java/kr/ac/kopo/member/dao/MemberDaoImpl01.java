package kr.ac.kopo.member.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.mapper.MemberMapper;
import kr.ac.kopo.member.vo.MemberVO;

@Repository
public class MemberDaoImpl01 implements MemberDAO {

	private MemberMapper memberMapper;
	
	public MemberDaoImpl01(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}
	
	@Override
	public List<MemberVO> selectAll() {
		return memberMapper.selectAll();
	}
	
	@Override
	public MemberVO login(MemberVO loginVO) {
		return memberMapper.login(loginVO);
	}


	@Override
	public void insert(MemberVO member) {
		memberMapper.insert(member);
	}

	@Override
	public MemberVO selectById(String id) {
		return memberMapper.selectById(id);
	}

}
