package kr.ac.kopo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Model model) {
		
		String msg = "스프링세계로 오신것을 환영합니다.";
		
		model.addAttribute("message", msg);
		
		//return "src/main/resources/template/index.html";
		return "index";
	}
}
