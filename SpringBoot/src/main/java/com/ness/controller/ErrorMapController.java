package com.ness.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
@Controller
public class ErrorMapController implements ErrorController {

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
