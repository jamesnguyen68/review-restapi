package com.dummy.rest.stock.constant;

public class Authority {
    
    private Authority(){
        throw new IllegalStateException("Authority class!!");
    }

    public static final String[] USER_AUTHORITIES = {"user:update","stock:add","stock:update","stock:delete"};
    public static final String[] ADMIN_AUTHORITIES = {"user:modify","user:create","user:delete","stock:add","stock:update","stock:delete"};



}


