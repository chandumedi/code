package com.ness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ness.bean.StoreItems;
import com.ness.dao.OrderItemDao;

@Service(value="oderservice")
public class OrderItemService {
	@Autowired
	private OrderItemDao orderItemDao;
	public List<StoreItems> fetchOrderItems() {
		return orderItemDao.fetchOrderedItems();
	}
	public void getCustomerDetails(String name) {
		 orderItemDao.getCustomerDetails(name);
	}

}
