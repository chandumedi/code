package com.ness.util;

import javax.servlet.http.HttpServletRequest;

public class ProvideErrorCodeUtil {

	public static int getErrorCode(HttpServletRequest request) {
		int errorCode=(int) request.getAttribute("javax.servlet.error.status_code");
		return errorCode;
	}

}
