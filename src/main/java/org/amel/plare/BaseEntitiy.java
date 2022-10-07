package org.amel.plare;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseEntitiy {
	private Date dateOfCreated;
	
	private Date dateOfUpdated;
	
	private String ipOfCreated;
	
	private String ipOfUpdated;
	
	private int memberIdOfUpdated;
	
	private BoardStatus status;
}
