package kr.ac.kopo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.ac.kopo.member.vo.MemberVO;

public interface MemberMapper {

	@Select("""
				select *
					from tbl_member
					where id = #{id} and pwd = #{pwd}
			""")
	MemberVO login(MemberVO loginVO);

	@Select("""
				select id, name, email, to_char(reg_date, 'yyyy-mm-dd') as regDate
					from tbl_member
				order by id
			""")
	List<MemberVO> selectAll();

	@Insert("""
			insert into tbl_member(id, pwd, name, email)
			values(#{id}, #{pwd}, #{name}, #{email})
			""")
	void insert(MemberVO member);

	@Select("""
				select id, name, email, to_char(reg_date, 'yyyy-mm-dd') as regDate
					from tbl_member
					where id = #{id}
			""")
	MemberVO selectById(String id);
}
