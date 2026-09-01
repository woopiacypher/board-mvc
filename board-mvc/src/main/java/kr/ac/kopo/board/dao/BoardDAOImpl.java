package kr.ac.kopo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.board.vo.BoardVO;

/**
 * Oracle DB에서 게시판테이블(tbl_board)에서 CRUD 기능클래스
 */

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private DataSource ds;
	
	@Override
	public List<BoardVO> selectAll() {		//전체 게시판 내역 출력

		List<BoardVO> boardList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql  = "select no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as regDate ";
		       sql += "  from tbl_board ";
		       sql += " order by no desc ";
		
		try {
			// Connection 객체 얻어오기(dbcp에서)
			conn = ds.getConnection();			//DB와 연결해주는 표준 인터페이스 API
			// sql를 sql실행객체에 넣어주기
			pstmt = conn.prepareStatement(sql);
			// sql실행 후 결과를 얻어오기
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String regDate = rs.getString("regDate");
				
				BoardVO board = new BoardVO();
				board.setNo(no);
				board.setTitle(title);
				board.setWriter(writer);
				board.setRegDate(regDate);
				
				boardList.add(board);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return boardList;
	}

	@Override
	public void insert(BoardVO board) {		// 새 글 등록
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into tbl_board(no, title, writer, content)";
				sql +="	value(seq_tbl_board_no.nextval,?,?,?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}








