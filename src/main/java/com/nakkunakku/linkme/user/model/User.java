package com.nakkunakku.linkme.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String id;
    private String passwd;
    private String email;
    private String userType;
    private String privateKey;
    
    public enum UserType {
        GuaranteeFund, DirectFund
    }
    
    public User(RequestAddUser requestAddUser) {
        this.id = requestAddUser.getId();
        this.passwd = requestAddUser.getPasswd();
        this.email = requestAddUser.getEmail();
        this.userType = requestAddUser.getUserType();
    }
}
