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
import com.example.demo.ServiceInterface;

@RequestMapping("/messages")
@Controller
public class MessageController {
	
	@Autowired
	private ServiceInterface service;
	
	private String message = null;
	
	/**
	 * Show All messages.
	 * @param model
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String messages(Model model) {
		return showMessages(model);
	}
	
	/**
	 * Register message.
	 * @param model
	 * @param messageForm
	 * @param bindingResult
	 * @param request
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String messagesPost(Model model,@Valid MessageForm messageForm , BindingResult bindingResult,HttpServletRequest request) {
		
		System.out.println("=============POST=================");
		
		if(bindingResult.hasErrors()) {
			List<Message> messages = service.getRecentMessages(100);
			model.addAttribute("messages",messages);
			return "messages";
		}
		
		service.save(new Message(messageForm.getName(),messageForm.getText(),request.getRemoteAddr()));
		model.addAttribute("response_message","記事を作成しました。");
		return showMessages(model);
	}

	/**
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(path="{id}",method=RequestMethod.GET)
	public String message(Model model,@PathVariable("id") Long id) {

		System.out.println("=============GET===============");
		List<Message> messages = service.getRecentMessages(100);
		return "messages";

	}

	/**
	 * Delete Message.
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(path="{id}",method=RequestMethod.DELETE)
	public String messageDelete(Model model , @PathVariable("id") Long id) {
		System.out.println("=============DELETE===============");

		service.delete(id);
		model.addAttribute("response_message","記事ID＝" + id + "を削除しました。");

		return showMessages(model);
	}
	
	/**
	 * This is a method of showing messages.
	 * @param model
	 * @return
	 */
	private String showMessages(Model model) {

		model.addAttribute("messageForm",new MessageForm());
		
		List<Message> messages = service.getRecentMessages(100);
		model.addAttribute("messages",messages);
		
		return "messages";
	}
}
