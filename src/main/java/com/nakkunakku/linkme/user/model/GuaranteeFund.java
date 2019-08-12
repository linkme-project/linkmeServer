package com.nakkunakku.linkme.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GuaranteeFund {
    String userId;
    String bankName;
    String bankNumber;
    
    public GuaranteeFund(RequestAddUser requestAddUser) {
        this.userId = requestAddUser.getId();
        this.bankName = requestAddUser.getGuaranteeFund().getBankName();
        this.bankNumber = requestAddUser.getGuaranteeFund().getBankNumber();
    }
    
    public GuaranteeFund(RequestUpdateUser requestUpdateUser) {
        this.userId = requestUpdateUser.getId();
        this.bankName = requestUpdateUser.getGuaranteeFund().getBankName();
        this.bankNumber = requestUpdateUser.getGuaranteeFund().getBankNumber();
    }
}
