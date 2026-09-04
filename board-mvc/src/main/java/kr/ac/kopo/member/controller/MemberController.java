package kr.ac.kopo.member.controller;

import java.util.List;

/*
 *  게시판 요청 처리
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

//@RequestMapping("/member")	--	/member를 생략하고 싶을때
@SessionAttributes(value = {"userVO"})	// value의 값을 session에 넣고 올리라는 실행문
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/member")
	public String list(Model model) throws Exception {
		
		List<MemberVO> memberList = memberService.getMemberList();
		System.out.println(memberList);
		model.addAttribute("memberList",memberList);
		
		return "member/memberlist";
	}
	
	@GetMapping("/member/join")
	public void joinForm(Model model) {
		
		model.addAttribute("memberVO",new MemberVO());
	}
	
	@PostMapping("/member/join")
	public String join(@Valid @ModelAttribute MemberVO member, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			System.out.println("입력값 오류!!!");
			return "member/join";
		}

		if (memberService.isDuplicateId(member.getId())) {
			result.rejectValue("id", "duplicate", "이미 사용중인 아이디");
			return "member/join";
		}

		memberService.join(member);

		return "redirect:/member";
	}
	
	@GetMapping("/member/{id}")
	public String myPage(@PathVariable String id, Model model) throws Exception {

		MemberVO member = memberService.getMemberByMyPage(id);
		model.addAttribute("member", member);

		return "member/MyPage";
	}
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	@PostMapping("/login")
	public String login(MemberVO member,Model model,HttpSession session) {
		
		MemberVO user = memberService.checkMember(member);
		// 로그인 실패
		if (user == null) {
			model.addAttribute("message","아이디와 패스워드");
			return "member/login";
		} else {
			// 로그인 성공
			// Session(세션)에 로그인 정보 저장
			session.setAttribute("userVO", user);	//서버는 스프링에서 String단순 문자열로만 저장하는 것외에 "객체"로 저장 가능
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();	//	session value를 사용할때 사용
		
		//session.invalidate();	// 세션 다 지우기	다만, @SessionAttribute()로 value 설정할땐 작동 불능
		return "redirect:/";
	}
}
