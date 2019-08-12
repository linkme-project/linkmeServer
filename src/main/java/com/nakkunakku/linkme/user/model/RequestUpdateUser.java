package com.nakkunakku.linkme.user.model;

import lombok.Data;

@Data
public class RequestUpdateUser {
    private String id;
    private String passwd;
    private String newPasswd;
    private String email;
    private String userType;
    
    private GuaranteeFund guaranteeFund;
    private DirectFund directFund;
}
