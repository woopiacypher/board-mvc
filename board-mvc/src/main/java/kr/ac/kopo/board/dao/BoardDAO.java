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
	List<BoardVO> selectAll();
	
	/**
	 * 새글 등록 기능
	 */
	void insert(BoardVO board);
}
