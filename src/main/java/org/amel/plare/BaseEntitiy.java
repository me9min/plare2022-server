package org.amel.plare;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseEntitiy {
	private Date date_of_created;
	
	private Date date_of_updated;
	
	private String ip_of_created;
	
	private String ip_of_updated;
	
	private int member_id_of_updated;
	
	private BoardStatus status;
}
