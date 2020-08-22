package springframework.mybreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static  org.junit.jupiter.api.Assertions.*;
import springframework.mybreweryclient.web.model.BeerDto;
import springframework.mybreweryclient.web.model.Customer;

@SpringBootTest
public class BreweryClientTest {
	
	@Autowired
	BreweryClient client;
	
	@Test
	public void getBeerById(){
		BeerDto dto = client.getBeerById(UUID.randomUUID());
		assertNotNull(dto);
		System.out.println("inside test method");

	}
	
	@Test
	public void saveNewBeer(){
		BeerDto beer = new BeerDto();
		beer.setBeerName("New Beer");
		URI uri=client.saveNewBeer(beer);
		assertNotNull(uri);
		System.out.println(uri);
	}
	
	@Test
	public void updateBeer(){
		BeerDto beer = new BeerDto();
		beer.setBeerName("update Beer");
		client.updateABeer(UUID.randomUUID(), beer);
		System.out.println("inside update test client");
	}
	@Test
	public void testGetCustomerById(){
		Customer customer=client.getCustomerById(UUID.randomUUID());
		assertNotNull(customer);
		System.out.println("inside testGetCustomerById method");
	}
	@Test
	public void testSaveNewCustomer(){
		Customer cust= new Customer();
		cust.setName("first customer");
		URI uri = client.saveNewCustomer(cust);
		assertNotNull(uri);
		System.out.println("saved customer uri "+uri);
	}
	@Test
	public void testUpdateCustomer(){
		Customer cust= new Customer();
		cust.setName("update customer");
		client.updateCustomer(cust, UUID.randomUUID());
		System.out.println("inside update customer test client");
	}

}
