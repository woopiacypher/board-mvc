package kr.ac.kopo.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDao;

	@Override
	public List<BoardVO> getBoardList(int page, int pageSize) throws Exception {
		int offset = (page - 1)*pageSize;
		List<BoardVO> boardList = boardDao.selectAll(offset, pageSize);

		return boardList;
	}

	@Override
	public void addNewBoard(BoardVO board) throws Exception {
		boardDao.insert(board);
	}

	@Override
	public BoardVO getBoardByBoardNo(int boardNo) throws Exception {
		return boardDao.selectByNo(boardNo);
	}

	@Override
	public int getTotalCount() throws Exception {
		return boardDao.getTotalCount();
	}

	@Override
	public void increaseViewCnt(int boardNo) throws Exception {
		boardDao.updateViewCnt(boardNo);
	}

	@Override
	public void modifyBoard(BoardVO board) throws Exception {
		boardDao.update(board);
	}

}
