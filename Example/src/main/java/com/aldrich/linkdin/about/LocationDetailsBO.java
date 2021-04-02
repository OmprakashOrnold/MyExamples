package com.aldrich.linkdin.about;

import lombok.Getter;
import lombok.Setter;

public class LocationDetailsBO {
	
	@Getter
	@Setter
	private String country;
	
	@Getter
	@Setter
	private String geographicArea;

	@Getter
	@Setter
	private String city;
	
	@Getter
	@Setter
	private String postalCode;
	
	@Getter
	@Setter
	private String line1;
	
	@Getter
	@Setter
	private String line2;

}
