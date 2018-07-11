package com.ness.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ness.util.ProvideErrorCodeUtil;

@Controller
public class LoginController {
	@RequestMapping(value = "/Home.htm")
	public ModelMap homePageView() {
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("message", "Welcome to Store!");
		return modelMap;
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView renderErrorPage(HttpServletRequest request, HttpServletResponse response) {
		int errorcode = ProvideErrorCodeUtil.getErrorCode(request);
		String errorViewName = "";
		String errorMessage = "";
		ModelAndView mav=new ModelAndView();
		switch (errorcode) {
		case 404:
			errorViewName = "Error";
			errorMessage = "Requested page not found!";
			break;
		case 505:
			errorViewName = "ServerError";
			errorMessage = "Some thing went wrong at server side!";
			break;
		default:
			break;
		}
		mav.setViewName(errorViewName);
		mav.addObject("errorMessage", errorMessage);
		return mav;
	}
}
