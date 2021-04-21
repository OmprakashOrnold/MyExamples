package com.aldrich.linkedin.event;

import lombok.Getter;
import lombok.Setter;

public class EventDetails {
	
	@Getter
	@Setter
	private String eventTitle;
	
	@Getter
	@Setter
	private String eventStartTime;

	@Getter
	@Setter
	private String eventEndime;
	
	@Getter
	@Setter
	private String eventLink;
	
	@Getter
	@Setter
	private String eventType;
	
	@Getter
	@Setter
	private String eventAttends;

}
