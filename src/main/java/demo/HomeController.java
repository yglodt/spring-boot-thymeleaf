package demo;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

	@GetMapping("/")
	public String index(final Model model) {
		model.addAttribute("now", LocalDateTime.now());
		return "index";
	}

	@GetMapping("/page2")
	public String page2() {
		return "page2";
	}

	@GetMapping("/page3")
	public String page3() {
		return "page3";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
