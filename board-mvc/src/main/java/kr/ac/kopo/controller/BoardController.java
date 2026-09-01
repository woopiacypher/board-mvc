package kr.ac.kopo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

/**
 * 게시판 요청 처리 컨트롤러
 */
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 전체 게시글 조회 요청
	@RequestMapping(value="/board")	// GET, POST 요청 둘다 처리
	public String list(Model model) throws Exception {
	
		List<BoardVO> boardList = boardService.getBoardList();
		
		model.addAttribute("boardList", boardList);
		
		return "board/list";
	}
	
	
	// 새글등록폼
	//@RequestMapping(value = "/board/write",method=RequestMethod.GET)
	@GetMapping("/board/write")
	public void writeForm(Model model) {
		
		model.addAttribute("boardVO", new BoardVO(100, "보이나?", "이찬용","2026-09-01"));
		
		System.out.println("Get /board/write...");
	}
	
	// 새글등록폼
	//@RequestMapping(value = "/board/write",method=RequestMethod.GET)
//s	@GetMapping("/board/write")
	public String writeForm2() {
		System.out.println("Get /board/write...");
		return "board/write2";
	}
	
	// 새글등록
	// title=aa&writer=bb&content=cc  get, post데이터를 받아옴
	//@RequestMapping(value = "/board/write",method=RequestMethod.POST)
	@PostMapping("/board/write")
	public String write(@Valid @ModelAttribute BoardVO board, BindingResult result) throws Exception {	//서블릿에서 처리하도록 예외처리 던짐
		
		System.out.println(board);
		
		if (result.hasErrors()) {			//오류가 발생하면,
			System.out.println("오류발생!!!");
			return "board/write";			//다시 글쓰기 페이지로 강제리턴
		}
		
		//boardService.addNewBoard(board);
		
		return "redirect:/board";
	}
	
	@PostMapping("/board/write")
	public String write2(@ModelAttribute BoardVO board) throws Exception {	//서블릿에서 처리하도록 예외처리 던짐
		System.out.println("Post /board/write...");
		
		System.out.println(board);
		
		boardService.addNewBoard(board);
				
		return "redirect:/board";
	}
	
	
}






