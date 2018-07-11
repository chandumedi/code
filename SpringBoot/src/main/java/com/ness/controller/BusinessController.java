package com.ness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ness.bean.StoreItems;
import com.ness.service.OrderItemService;

@Controller
public class BusinessController {
	@Autowired
	private OrderItemService orderItemService;

	@RequestMapping(value = "/viewOrders.htm", method = RequestMethod.GET)
	public ModelAndView viewOrderedItems() {
		ModelAndView mav = new ModelAndView();
		List<StoreItems> storeItemsList = orderItemService.fetchOrderItems();
		mav.addObject("orderlist", storeItemsList);
		mav.addObject("message", "Welcome to Store!");
		return mav;
	}
	
	@RequestMapping(value="/viewcustomerdetails.htm",method=RequestMethod.GET)
	public void showCustomerDetails(@RequestParam("name") String name) {
		System.out.println("Hello"+name);
		orderItemService.getCustomerDetails(name);
	}
}
