package kr.ac.kopo.member.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public List<MemberVO> getMemberList() throws Exception {
		return memberDAO.selectAll();
	}

	@Override
	public void join(MemberVO member) throws Exception {
		memberDAO.insert(member);
	}

	@Override
	public MemberVO getMemberByMyPage(String memberId) throws Exception {
		return memberDAO.selectById(memberId);
	}

	@Override
	public MemberVO checkMember(MemberVO member) {
		return memberDAO.login(member);
	}

	@Override
	public boolean isDuplicateId(String id) throws Exception {
		return memberDAO.selectById(id) != null;
	}

}
