package kr.ac.kopo.mapper;	//namespace

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardMapper {

	/*
	@Select("""
			select no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as regDate
			  from tbl_board
			 order by no desc
			""")
	 */			
	List<BoardVO> selectAll();
	
	void insert(BoardVO board);
	
	@Select("""
				select no, title, writer, content, view_cnt as viewCnt
					, to_char(reg_date, 'yyyy-mm-dd') as regDate
					from tbl_board
					where no = #{no}
			""")
	BoardVO selectByNo(int boardNo);

			
}
