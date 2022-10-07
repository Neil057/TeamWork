package com.neil.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neil.demo.dto.MessageDto;
import com.neil.demo.model.Messages;
import com.neil.demo.service.MessageService;

@Controller
public class MessagesController {
	
	@Autowired
	private MessageService mService;
	
	@GetMapping("/messages/add")
	public String addMsg(Model model) {
		
		Messages m1 = new Messages();
		
		model.addAttribute("messages", m1);
		
		Messages lastestMsg = mService.findLastest();
		model.addAttribute("lastestMsg", lastestMsg);
		
		
		return "messages/addMessagePage"; 
	}
	
	@PostMapping("/messages/post")
	public String postMsg(@ModelAttribute(name="messages") Messages msg, Model model) {
		
		mService.insert(msg);
		
        Messages m1 = new Messages();
		
		model.addAttribute("messages", m1);
		
		Messages lastestMsg = mService.findLastest();
		
		model.addAttribute("lastestMsg", lastestMsg);
		
		return "messages/addMessagePage"; 
	}
	
	@GetMapping("/messages/page")
	public String showMessages(@RequestParam(name = "p",defaultValue = "1") Integer pageNumber, Model model ) {
		Page<Messages> page = mService.findByPage(pageNumber);
		
		model.addAttribute("page", page);
		
		return "messages/showMessages";
	}
	
	@GetMapping("/messages/edit")
	public String editMessage(@RequestParam(name="id") Integer id, Model model ) {
		Messages m1 = mService.findById(id);
		
		model.addAttribute("messages", m1);
		
		return "messages/editMessage";
	}
	
	@PostMapping("/messages/edit")
	public String editMessagePost(@ModelAttribute(name="messages") Messages msg ) {
		mService.insert(msg);
		
		return "redirect:/messages/page";
	}
	
	@GetMapping("/messages/delete")
	public String deleteMessage(@RequestParam(name="id") Integer id) {
		mService.deleteById(id);
		return "redirect:/messages/page";
	}
	
	@ResponseBody
	@PostMapping("/messages/api/post")
	public List<Messages> postMessagsApi(@RequestBody MessageDto dto){
		String userInput = dto.getInputText();
		
		// ...
		
		Messages newMsg = new Messages();
		newMsg.setText(userInput);
		
		mService.insert(newMsg);
		
		Page<Messages> page = mService.findByPage(1);
		return page.getContent();
	}
	
	@GetMapping("/messages/ajax")
	public String getAjaxPage() {
		return "messages/ajax-message";
	}

}
