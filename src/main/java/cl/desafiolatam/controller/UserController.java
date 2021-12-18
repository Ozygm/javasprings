package cl.desafiolatam.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.desafiolatam.model.Role;
import cl.desafiolatam.model.User;
import cl.desafiolatam.security.WebSecurityConfig;
import cl.desafiolatam.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userS;
	
	@Autowired
	BCryptPasswordEncoder bcrypt;
	
	
	@GetMapping("/register")
	public ModelAndView register(User user) {
		ModelAndView mav = new ModelAndView ("register");
		mav.addObject("user", new User());
		return mav;
	}
	
	@PostMapping("/register")
	public String registers (@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/register";
		} else if (userS.findByEmail(user.getEmail()) == null) {
			user.setRole(Role.User);
			user.setPassword(bcrypt.encode(user.getPassword()));
			user.setPasswordConfirmation(bcrypt.encode(user.getPasswordConfirmation()));
			userS.createUser(user);
			return "redirect:/login";
		} else {
			return "redirect:/register";
		}
		
	}
	
	@GetMapping("/login")
	public ModelAndView login (User user) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout() {
		ModelAndView mav = new ModelAndView("/login");
		SecurityContextHolder.getContext().setAuthentication(null);
		return mav;
	}
	
	
	
//	@PostMapping("/login")
//	public String loginV (User user) {
//		User usernuevo = new User();
//		usernuevo = userS.findByName(user.getUsername());
//		if (usernuevo.getPassword().compareTo(user.getPassword()) == 0) {
//			System.out.println(user.getPassword()+" PASSWORD DE USER");
//			System.out.println(usernuevo.getPassword()+" PASSWORD DE USERNUEVO");
//			return "redirect:/shows/list";
//		} else {
//			return "redirect:/login";
//		}
//	}
	
	

}
