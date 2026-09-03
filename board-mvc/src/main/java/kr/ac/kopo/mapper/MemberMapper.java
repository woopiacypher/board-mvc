package kr.ac.kopo.mapper;

import org.apache.ibatis.annotations.Select;

import kr.ac.kopo.member.vo.MemberVO;

public interface MemberMapper {

	@Select("""
				select *
					from tbl_member
					where id = #{id} and password = #{password}
			""")
	MemberVO login(MemberVO loginVO);
}
