package com.ness.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ness.bean.CustomerDetails;
import com.ness.bean.StoreItems;
import com.ness.dao.OrderItemDao;

@Service(value="oderservice")
public class OrderItemService {
	@Autowired
	private OrderItemDao orderItemDao;
	public List<StoreItems> fetchOrderItems() {
		return orderItemDao.fetchOrderedItems();
	}
	public void getCustomerDetails(CustomerDetails customerDetails,String realPath) throws IOException {
		int rowIndex = 0;
		List<CustomerDetails> customerList= orderItemDao.getCustomerDetails(customerDetails);
		XSSFWorkbook workbook=new XSSFWorkbook();
		Sheet sheet=workbook.createSheet("Customer Details");
		Iterator<CustomerDetails> iterator=customerList.iterator();
		while(iterator.hasNext()) {
			CustomerDetails  customerData=iterator.next();
			Row row = sheet.createRow(rowIndex++);
			Cell cell1=row.createCell(0);
			cell1.setCellValue(customerData.getUsedId());
			Cell cell2=row.createCell(1);
			cell2.setCellValue(customerData.getName());
			Cell cell3=row.createCell(2);
			cell3.setCellValue(customerData.getRegion());
		}
		FileOutputStream fos = new FileOutputStream(realPath+"\\CustomerDetails.xls");
		System.out.println("Path is-======================="+ realPath+"\\CustomerDetails.xls");
		workbook.write(fos);

	}

}
