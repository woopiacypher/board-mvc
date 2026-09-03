package kr.ac.kopo.board.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.config.DBConfig;
import kr.ac.kopo.member.vo.MemberVO;

@SpringJUnitConfig(classes = {DBConfig.class})
public class BoardDBTest {

	@Autowired
	private DataSource ds;
	
	@Autowired
	private BoardDAO boardDao;
	
	@Disabled
	@Test
	public void DB접속Test() throws Exception{

		//assertNotNull(ds);
		Connection conn = ds.getConnection();
		assertNotNull(conn);
	}
	
	@Test
	public void 전체게시글조회() throws Exception {
		List<BoardVO> list = boardDao.selectAll();
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
	@Test
	public void 로그인Test() throws Exception {
		MemberVO member = new MemberVO();
		member.setId("user");
		member.setPwd("user");
		
		assertNotNull(member);
	}
}






