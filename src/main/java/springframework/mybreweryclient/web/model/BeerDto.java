package springframework.mybreweryclient.web.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;



public class BeerDto {
	@Null
	private UUID  id ;//not allow the client to set the id property
	
	@NotBlank
	private String beerName;
	@NotBlank
	private String berrStyle;
	@Positive
	private Long upc;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getBeerName() {
		return beerName;
	}
	public void setBeerName(String beerName) {
		this.beerName = beerName;
	}
	public String getBerrStyle() {
		return berrStyle;
	}
	public void setBerrStyle(String berrStyle) {
		this.berrStyle = berrStyle;
	}
	public Long getUpc() {
		return upc;
	}
	public void setUpc(Long upc) {
		this.upc = upc;
	}
	public BeerDto(UUID id, String beerName, String berrStyle, Long upc) {
		super();
		this.id = id;
		this.beerName = beerName;
		this.berrStyle = berrStyle;
		this.upc = upc;
	}
	
	public BeerDto(){
		
	}
	
	

}
