package com.seleniumexpress.Rc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.seleniumexpress.Rc.api.UserInfoDto;
import com.seleniumexpress.Rc.service.RCAppServiceImpl;

@EnableWebMvc
@Controller
@SessionAttributes("userInfo")

public class RCAppController {

	@Autowired
	private RCAppServiceImpl relationAppSeviceimp;

	@RequestMapping("/")
	public String showHomePage(Model model) {
		model.addAttribute("userInfo", new UserInfoDto());

		return "Homepage";
	}

	@RequestMapping("/process-homepage")
	public String showResultPage(Model model, @Valid UserInfoDto userInfo, BindingResult result) {

		model.addAttribute("userInfo", userInfo);
		model.addAttribute(BindingResult.MODEL_KEY_PREFIX + "userInfo", result);
		System.out.println(userInfo.getUserName() + "Process Homepage" + userInfo.getOthersName());
		if (result.hasErrors()) {
			return "Homepage";
		}
		String appResult=relationAppSeviceimp.CalculateRelation(userInfo.getUserName(), userInfo.getOthersName());
		userInfo.setAppResult(appResult);
		return "result-page";
	}

}
