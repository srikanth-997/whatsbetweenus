package com.seleniumexpress.Rc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.seleniumexpress.Rc.api.EmailDTO;
import com.seleniumexpress.Rc.api.UserInfoDto;
import com.seleniumexpress.Rc.service.RCAppEmailService;

@Controller

public class EmailController {
	
	@Autowired
	private RCAppEmailService RCAppEmailService;
	
	@RequestMapping("/sendEmail")
	public String sendEmail(Model model)
	{
		
		model.addAttribute("emailDTO", new EmailDTO()); // this is equals to @ModelAttribute("emailDTO") EmailDTO emailDTO
	   
		return "send-email-page";
	}
	
	@RequestMapping("/process-email")
	public String processEmail(@SessionAttribute("userInfo") UserInfoDto userInfo,@ModelAttribute("emailDTO") EmailDTO emailDTO)
	{
		
		RCAppEmailService.sendEmail(userInfo.getUserName(),emailDTO.getUserEmail(),userInfo.getAppResult());
	  
		
		return "process-email-page";
	}

}
