package com.donriver.model;


import org.apache.log4j.Logger;




/*
 * @Author : Himanshu Garg
 */

public class DataTableColumn {
	
	private static  Logger logger = Logger.getLogger(DataTableColumn.class);
	
    private String header;
    private String property;
    
    public DataTableColumn(String header, String property) {
        this.header = header;
        this.property = property;
    }
    
    public String getHeader() {
        return header;
    }
    public String getProperty() {
        return property;
    } 
    
}
