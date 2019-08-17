package com.nakkunakku.linkme.user.model;

import lombok.Data;

@Data
public class ResponseUserInfo {
    private String id;
    private String email;
    private String userType;
    
    private GuaranteeFund guaranteeFund;
    private DirectFund directFund;
    private FundSeller fundSeller;
}
