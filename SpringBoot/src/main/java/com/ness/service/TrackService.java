package com.ness.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ness.bean.CustomerDetails;

@Service("trackService")
public class TrackService {

	public List<String> trackorderedItem(CustomerDetails customerDetails) {
		if(customerDetails.getTrackDate()==null||customerDetails.getTrackDate().length()==0) {
			customerDetails.setTrackDate(String.valueOf(new Date()));
		}
		Map<CustomerDetails,String> trackDataMap=new HashMap<>();
		CustomerDetails secondObj=customerDetails;
		trackDataMap.put(customerDetails, "first");
		trackDataMap.put(secondObj, "thrird");
		trackDataMap.put(new CustomerDetails(), "second");
		System.out.println("SIZE"+trackDataMap.size());
		for(CustomerDetails mapData:trackDataMap.keySet()) {
			System.out.println(mapData.toString());
			System.out.println(trackDataMap.get(mapData));
		}
		return null;
	}
	
}
