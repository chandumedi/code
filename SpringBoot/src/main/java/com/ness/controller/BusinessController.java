package com.ness.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ness.bean.CustomerDetails;
import com.ness.bean.StoreItems;
import com.ness.service.OrderItemService;
import com.ness.service.TrackService;

@Controller
public class BusinessController {
	@Autowired
	private OrderItemService orderItemService;

	@Autowired
	private TrackService trackService;

	@Autowired
	ServletContext context;

	@RequestMapping(value = "/viewOrders.htm", method = RequestMethod.GET)
	public ModelAndView viewOrderedItems() {
		ModelAndView mav = new ModelAndView();
		List<StoreItems> storeItemsList = orderItemService.fetchOrderItems();
		mav.addObject("orderlist", storeItemsList);
		mav.addObject("message", "Welcome to Store!");
		return mav;
	}

	@RequestMapping(value = "/viewcustomerdetails.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	public ModelAndView showCustomerDetails(@RequestBody CustomerDetails customerDetails) {
		ModelAndView mav = new ModelAndView();
		List<String> arrayList = new ArrayList<>();
		arrayList = trackService.trackorderedItem(customerDetails);
		return mav;
	}

	@RequestMapping(value = "/exportcustomerdetails.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	public void exportCustomerDetails(HttpServletRequest request, HttpServletResponse response,
			@RequestBody CustomerDetails customerDetails) throws IOException {
		System.out.println("Hello" + customerDetails);
		String fileName = "CustomerDetails.xls";
		response.setHeader("Content-disposition", "attachment; filename=" + fileName);
		String realPath = context.getRealPath("");
		orderItemService.getCustomerDetails(customerDetails, realPath);
		String outFile = realPath + "\\CustomerDetails.xls";
		System.out.println("Path is-=======================" + outFile);
		InputStream inputStream = new BufferedInputStream(new FileInputStream(new File(outFile)));
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}
}
