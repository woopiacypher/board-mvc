package kr.ac.kopo.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	@Override
	public List<MemberVO> getMemberList() throws Exception {

			List<MemberVO> getMemberList = memberDao.selecAll();
			return getMemberList;
		}
	}

	@Override
	public void addNewMember(MemberVO member) throws Exception {
		memberDao.insert(board);
	}

	@Override
	public BoardVO getMemberByMyPage(int memberNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
