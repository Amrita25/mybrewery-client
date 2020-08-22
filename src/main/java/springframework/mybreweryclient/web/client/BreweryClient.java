package springframework.mybreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import springframework.mybreweryclient.web.model.BeerDto;
import springframework.mybreweryclient.web.model.Customer;

@Component
@ConfigurationProperties(value="client.brewery",ignoreUnknownFields=false)
public class BreweryClient {
	
	public static final String BEER_PATH_V1="api/v1/beer/";
	public static final String CUSTOMER_PATH="api/v1/customer/";
	
	RestTemplate restTemplate;
	private String apihost;
	
	
	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	public String getApihost() {
		return apihost;
	}
	public void setApihost(String apihost) {
		this.apihost = apihost;
	}
	
	public BeerDto getBeerById(UUID id){
		return restTemplate.getForObject(apihost+BEER_PATH_V1+id.toString(), BeerDto.class);
	}
	
	public URI saveNewBeer(BeerDto beerDto){
		return restTemplate.postForLocation(apihost+BEER_PATH_V1, beerDto);
		
	}
	
	public void updateABeer(UUID id,BeerDto beerDto){
		restTemplate.put(apihost+BEER_PATH_V1+id.toString(), beerDto);
	}
	
	public Customer getCustomerById(UUID custID){
		return restTemplate.getForObject(apihost+CUSTOMER_PATH+custID.toString(), Customer.class);
	}
	public URI saveNewCustomer(Customer customer){
		return restTemplate.postForLocation(apihost+CUSTOMER_PATH, customer);
	}
	public void updateCustomer(Customer customer,UUID custID){
		 restTemplate.put(apihost+CUSTOMER_PATH+custID.toString(), customer);
	}
	
	

}
