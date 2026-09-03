package kr.ac.kopo.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/member")
	public String list(Model model) throws Exception {
		
		List<MemberVO> memberList = memberService.getMemberList();
		
		model.addAttribute("memberList",memberList);
		
		return "board/list";
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
			result.rejectValue("id","duplicate","이미 사용중인 아이디");
			return "member/join";
		}
		
		memberService.join(member);
		
		return "redirect:/member";
	}
	
	@GetMapping("/member/{id}")
	public String MyPage(@PathVariable String memberId, Model model) throws Exception {
		
		MemberVO member = memberService.getMemberByMyPage(memberId);
		model.addAttribute("member",member);
		
		return "member/MyPage";
	}
	
	@GetMapping("login")
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
			session.setAttribute("userVO", user);
		}
		
		return "redirect:/";
	}
}
