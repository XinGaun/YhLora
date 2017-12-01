package com.rpc;

import java.io.Serializable;

public class SelectBo implements Serializable{
	private static final long serialVersionUID = 1L;  
    private String name;  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
      
    public Integer selectName(String name)  
    {  
        Integer i = name.length();  
        return i;  
    }  
}
