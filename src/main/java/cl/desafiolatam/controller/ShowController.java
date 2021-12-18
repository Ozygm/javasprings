package cl.desafiolatam.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.desafiolatam.model.Show;
import cl.desafiolatam.service.RatingService;
import cl.desafiolatam.service.ShowService;
import cl.desafiolatam.service.UserService;

@Controller
@RequestMapping("/shows")
public class ShowController {

	@Autowired
	private UserService userS;
	
	
	@Autowired
	private ShowService showS;
	
	@Autowired
	private RatingService ratingS;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("home");
		List<Show> tvShows = showS.findAll();
		mav.addObject("shows", showS.findAll());
		return mav;
	}
	
	@GetMapping("/list/add")
	public ModelAndView add(Show show) {
		ModelAndView mav = new ModelAndView("addShow");
		mav.addObject("show", new Show());
		return mav;
	}
	
	@PostMapping("/list/add")
	public String adds(@Valid Show show, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/shows/list/add";
		}
		showS.saveShow(show);
		return "redirect:/shows/list";
	}
	
	@GetMapping("/list/delete")
	public String delete(@RequestParam("id")Long id) {
		
		showS.delShow(id);
		return "redirect:/shows/list";
	}
	
	@GetMapping("/list/edit")
	public ModelAndView edit(@RequestParam("id")Long id, Show show) {
		ModelAndView mav = new ModelAndView("editShow");
		mav.addObject("show", showS.findById(id));
		return mav;
	}
	
	@PostMapping("/list/edit")
	public String edits (@ModelAttribute Show show) {
		showS.edit(show);
		return "redirect:/shows/list";
	}
	
	@GetMapping ("/list/rating")
	public ModelAndView addRating (@RequestParam("id")Long id, Show show) {
		ModelAndView mav = new ModelAndView("rating");
		mav.addObject("show", showS.findById(id));
		return mav;
	}
	
	
}
