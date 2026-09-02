package kr.ac.kopo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import kr.ac.kopo.board.vo.MemberVO;
import kr.ac.kopo.member.service.MemberService;

public class MemberController {
	
	@Autowired
	private MemberService memberService;	//
	
	@RequestMapping(value="/member")
	public String list(Model model) throws Exception {
		
		List<BoardVO> memberList = memberService.getMemberList();
		
		model.addAttribute("memberList",memberList);
		
		return "board/list";
	}
	
	@GetMapping("/member/join")
	public void joinForm(Model model) {
		
		model.addAttribute("memberVO",new memberVO());
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
	
}
