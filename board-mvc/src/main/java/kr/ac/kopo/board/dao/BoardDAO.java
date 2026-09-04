package kr.ac.kopo.board.dao;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

/**
 * 게시판 CRUD를 위한 DAO 클래스
 */
public interface BoardDAO {

	/**
	 * 전체게시글 조회 기능
	 */
	List<BoardVO> selectAll(int offset, int pageSize);
	
	/**
	 * 새글 등록 기능
	 */
	void insert(BoardVO board);
	
	/**
	 * 해당 번호의 게시글 조회 기능
	 * @param boardNo 조회할 글번호
	 * @return 조회된 게시글
	 */
	BoardVO selectByNo(int boardNo);
	
	int getTotalCount();
	
	void updateViewCnt(int boardNo);
	
	void update(BoardVO board);
}
