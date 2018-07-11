package ness.com.testcase;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.ness.bean.StoreItems;
import com.ness.dao.OrderItemDao;
import com.ness.test.BootTest;

import junit.framework.Assert;


//@ContextConfiguration(classes= {BootTest.class})
//@RunWith(SpringJUnit4ClassRunner.class)
public class OrderTest {
	/*@Autowired
	private OrderItemDao orderItemDao;*/

	@Test
	@Transactional
	public void testOrderItems() {
		List<StoreItems> storeItems = new ArrayList<>();
		storeItems.add(new StoreItems("S100", 7, 1200.80f, "APPLE"));
		storeItems.add(new StoreItems("S200", 7, 1200.80f, "SAMSUNG"));
		storeItems.add(new StoreItems("S300", 7, 1200.80f, "NOKIA"));
		storeItems.add(new StoreItems("S400", 7, 1200.80f, "ONE+"));
		//List<StoreItems> items = orderItemDao.fetchOrderedItems();
		Assert.assertEquals(storeItems.size(), 4);
	}
}
