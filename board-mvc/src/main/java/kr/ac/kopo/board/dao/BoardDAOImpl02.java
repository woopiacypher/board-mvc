package kr.ac.kopo.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.mapper.BoardMapper;

@Repository
public class BoardDAOImpl02 implements BoardDAO {

	private BoardMapper boardMapper;
	
	public BoardDAOImpl02(BoardMapper boardMapper) {
		super();
		this.boardMapper = boardMapper;
	}
	
	@Override
	public List<BoardVO> selectAll() {
		return boardMapper.selectAll();
	}

	@Override
	public void insert(BoardVO board) {
		// TODO Auto-generated method stub

	}

}
