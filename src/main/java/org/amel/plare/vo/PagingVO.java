package org.amel.plare.vo;

public class PagingVO {
	
	 private int page;
	    private int recordSize;
	    private int pageSize;
	    
	    public PagingVO() {
	    	this.page = 1;
	    	this.recordSize = 10;
	    	this.pageSize = 5;
	    }
	    
	    public int getOffset() {
	    	return (page - 1) * recordSize;
	    }
	
}
