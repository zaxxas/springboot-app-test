package com.example.demo.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Message;
import com.example.demo.MessageForm;
import com.example.demo.MessageService;

@RequestMapping("/")
@Controller
public class HomeController {
	
	@Autowired
	private MessageService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model) {
		System.out.println("=========home==========");
		return "home";
	}
}
