package com.dummy.rest.stock.constant;

import static com.dummy.rest.stock.constant.Authority.*;


public enum Role {
    ROLE_USER(USER_AUTHORITIES), 
    ROLE_ADMIN(ADMIN_AUTHORITIES);


    private String[] authorities;

    // # maximum paramater?
    Role(String ... authorities){
        this.authorities = authorities;
    }

    public String[] getAuthorities(){
        return authorities;
    }
}
