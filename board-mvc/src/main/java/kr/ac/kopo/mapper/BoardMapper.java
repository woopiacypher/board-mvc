package kr.ac.kopo.mapper;	//namespace

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardMapper {


	void insert(BoardVO board);

	@Select("""
				select no, title, writer, content, view_cnt as viewCnt
					, to_char(reg_date, 'yyyy-mm-dd') as regDate
					from tbl_board
					where no = #{no}
			""")
	
	BoardVO selectByNo(int boardNo);

	
	/** 전체 게시글 조회 (페이징) - boardMapper.xml의 selectAll에 매핑 */
	List<BoardVO> selectAll(@Param("offset") int offset, @Param("pageSize") int pageSize);
	
	/** 전체 게시글 수 - boardMapper.xml의 getTotalCount에 매핑 */
	int getTotalCount();
	
	/** 조회수 */
	@Update("""
				update tbl_board
				   set view_cnt = view_cnt + 1
				 where no = #{no}
			""")
	void updateViewCnt(int no);

	/** 게시글 수정 */
	@Update("""
				update tbl_board
				   set title = #{title}
				     , content = #{content}
				 where no = #{no}
			""")
	void update(BoardVO board);
}