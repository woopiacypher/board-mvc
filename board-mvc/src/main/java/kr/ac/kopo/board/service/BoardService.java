package kr.ac.kopo.board.service;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardService {

	/** 전체 게시판 리스트 (페이징) */
	List<BoardVO> getBoardList(int page, int pageSize) throws Exception;

	/** 전체 게시글 수 */
	int getTotalCount() throws Exception;

	/** 게시글 추가 */
	void addNewBoard(BoardVO board) throws Exception;

	/** 상세 게시글 보기 */
	BoardVO getBoardByBoardNo(int boardNo) throws Exception;

	/** 조회수 증가 */
	void increaseViewCnt(int boardNo) throws Exception;

	/** 게시글 수정 */
	void modifyBoard(BoardVO board) throws Exception;
}