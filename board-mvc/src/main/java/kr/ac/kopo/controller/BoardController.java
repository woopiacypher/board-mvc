package kr.ac.kopo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		
		model.addAttribute("boardVO", new BoardVO());
	}
	
	// 새글등록폼
	//@RequestMapping(value = "/board/write",method=RequestMethod.GET)
	//@GetMapping("/board/write")
	public String writeForm2() {
		System.out.println("Get /board/write...");
		return "board/write2";
	}
		
	// 새글등록
	// title=aa&writer=bb&content=cc
	//@RequestMapping(value = "/board/write",method=RequestMethod.POST)
	@PostMapping("/board/write")
	public String write(@Valid @ModelAttribute BoardVO board, BindingResult result) throws Exception {
		
		System.out.println(board);
		
		if(result.hasErrors()) {
			System.out.println("오류발생!!!");
			return "board/write";
		}
		
		boardService.addNewBoard(board);
		
		return "redirect:/board";
	}
//	@PostMapping("/board/write")
	public String write2(BoardVO board) throws Exception {
		System.out.println("Post /board/write...");
		
		System.out.println(board);
		
		boardService.addNewBoard(board);
		
		//return "board/writeResult";
		return "redirect:/board";
	}
	
	
}






