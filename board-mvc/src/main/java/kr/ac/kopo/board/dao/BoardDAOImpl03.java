package kr.ac.kopo.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.board.vo.BoardVO;
/**
 * MyBatis(mapper xml 활용) 게시판 CRUD
 */
//@Repository
public class BoardDAOImpl03 implements BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<BoardVO> selectAll() {
		System.out.println("BoardDAOImp03...selectAll");
		List<BoardVO> boardList = sqlSessionTemplate.selectList("board.dao.BoardDAO.selectAll");	//CRUD 다 SqlSessionTemplate에서 제공하는 메서드를 사용해야함
		return boardList;
	}

	@Override
	public void insert(BoardVO board) {
		// TODO Auto-generated method stub

	}

	@Override
	public BoardVO selectByNo(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
