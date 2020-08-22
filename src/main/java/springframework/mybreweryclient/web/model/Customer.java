package springframework.mybreweryclient.web.model;

import java.util.UUID;

public class Customer {
	private UUID id ;
	private String name;
	
	public Customer() {
	}
	public Customer(UUID id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
