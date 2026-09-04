package kr.ac.kopo.board.service;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardService {
	
	// 전체 게시판 리스트
	List<BoardVO> getBoardList() throws Exception;
	// 게시글 추가
	void addNewBoard(BoardVO board) throws Exception;
	// 상세 게시글 보기
	BoardVO getBoardByBoardNo(int boardNo) throws Exception;
}
