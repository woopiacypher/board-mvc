package kr.ac.kopo.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.mapper.BoardMapper;

	//Board"Mapper"를 통한 CRUD 기능DAO 작성 방법
	// MyBatis를 java로 사용하는 법
@Repository
public class BoardDAOImpl02 implements BoardDAO {

	private BoardMapper boardMapper;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public BoardDAOImpl02(BoardMapper boardMapper) {
		super();
		this.boardMapper = boardMapper;
	}
	
	@Override
	public List<BoardVO> selectAll(int offset, int pageSize) {
		return boardMapper.selectAll(offset, pageSize);
	}

	@Override
	public void insert(BoardVO board) {
		//sqlSessionTemplate.insert("board.dao.BoardDAO.insert", board);
		boardMapper.insert(board);
	}

	@Override
	public BoardVO selectByNo(int boardNo) {
		return boardMapper.selectByNo(boardNo);
	}

	@Override
	public int getTotalCount() {
		return boardMapper.getTotalCount();
	}

	@Override
	public void updateViewCnt(int boardNo) {
		boardMapper.updateViewCnt(boardNo);
	}

	@Override
	public void update(BoardVO board) {
		boardMapper.update(board);
		
	}

}
