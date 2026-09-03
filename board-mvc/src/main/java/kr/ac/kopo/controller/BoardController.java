package kr.ac.kopo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	private BoardService boardService;		//view에서 받은걸 service단에 넘겨야해서 생성자 생성
	
	// 전체 게시글 조회 요청
	@RequestMapping(value="/board")	// GET, POST 요청 둘다 처리
	public String list(Model model) throws Exception {
	
		List<BoardVO> boardList = boardService.getBoardList();	//@Service단으로 넘어간 부분
		
		model.addAttribute("boardList", boardList);	//View에서 받은 form.html의 정보를 셋팅
		
		return "board/list";	// list.html에 리턴반환
	}
	
	
	// 새글등록폼
	//@RequestMapping(value = "/board/write",method=RequestMethod.GET)
	@GetMapping("/board/write")	// get 방식으로 넘어올때,
	public void writeForm(Model model) {
		
		model.addAttribute("boardVO", new BoardVO());
	}
	
	// 새글등록폼
	//@RequestMapping(value = "/board/write",method=RequestMethod.GET)
	//@GetMapping("/board/write")
	public String writeForm2() {			// view 단에서 잘못된 오류처리 방지
		System.out.println("Get /board/write...");
		return "board/write2";
	}
		
	// 새글등록
	// title=aa&writer=bb&content=cc
	//@RequestMapping(value = "/board/write",method=RequestMethod.POST)
	@PostMapping("/board/write")		// 잘못된 입력에 의한 오류 발생시, 서비스단에서 처리할때,		post방식으로 넘어올때,
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
	
	// http://localhost:8080/board-mvc/board/detail?no=23			get 방식
	@GetMapping("/board/detail")
	public String detail(@RequestParam("no") int boardNo, Model model) throws Exception {
		//System.out.println("no : "+boardNo);
		
		BoardVO board = boardService.getBoardByBoardNo(boardNo);
		model.addAttribute("board",board);
		
		return "board/detail";
	}
	// rest방식
	@GetMapping("/board/{no}")				
	public String detail2(@PathVariable("no") int boardNo, Model model) throws Exception {
		//System.out.println("no : "+boardNo);
		
		BoardVO board = boardService.getBoardByBoardNo(boardNo);
		model.addAttribute("board",board);
		
		return "board/detail";
	}
}






