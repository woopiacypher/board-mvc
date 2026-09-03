package kr.ac.kopo.member.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	@Override
	public List<MemberVO> getMemberList() throws Exception {

			List<MemberVO> getMemberList = memberDao.selectAll();
			return getMemberList;
		
	}

	@Override
	public void addNewMember(MemberVO member) throws Exception {
		memberDao.insert(member);
	}

	@Override
	public BoardVO getMemberByMyPage(int memberNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO checkMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

}
