package com.nakkunakku.linkme.user.model;

import lombok.Data;

@Data
public class RequestAddUser {
    private String id;
    private String passwd;
    private String email;
    private String userType;
    
    private GuaranteeFund guaranteeFund;
    private DirectFund directFund;

    class GuaranteeFund {
        String bankName;
        String bankNumber;
    }

    class DirectFund {
        String phoneNum;
        String socialSecurtyNum;
    }
}
