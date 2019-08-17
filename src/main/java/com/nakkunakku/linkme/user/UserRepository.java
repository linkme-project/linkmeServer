package com.nakkunakku.linkme.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nakkunakku.linkme.user.model.DirectFund;
import com.nakkunakku.linkme.user.model.FundSeller;
import com.nakkunakku.linkme.user.model.GuaranteeFund;
import com.nakkunakku.linkme.user.model.User;

@Repository
public class UserRepository {
    @Autowired
    private SqlSession sqlSession;

    public String getLocalTime() {
        return sqlSession.selectOne("user.getCurrentDateTime");
    }

    public int addUser(User user) {
        return sqlSession.insert("user.addUser", user);
    }

    public int addDirectFund(DirectFund directFund) {
        return sqlSession.insert("user.addDirectFund", directFund);
    }

    public int addGuaranteeFund(GuaranteeFund guaranteeFund) {
        return sqlSession.insert("user.addGuaranteeFund", guaranteeFund);
    }
    public int addFundSeller(FundSeller fundSeller) {
    	return sqlSession.insert("user.addFundSeller", fundSeller);
    }
    
    
    

    public User findUser(String userId) {
        return sqlSession.selectOne("user.findUser", userId);
    }

    public DirectFund findDirectFund(String userId) {
        return sqlSession.selectOne("user.findDirectFund", userId);
    }

    public GuaranteeFund findGuaranteeFund(String userId) {
        return sqlSession.selectOne("user.findGuaranteeFund", userId);
    }
    public FundSeller findFundSeller(String userId) {
    	return sqlSession.selectOne("user.findFundSeller", userId);
    }
    
    
    
    
    public void updateUser(User user) {
        sqlSession.update("user.updateUser", user);
    }
    public void updateDirectFund(DirectFund directFund) {
        sqlSession.update("user.updateDirectFund", directFund);
    }
    public void updateGuaranteeFund(GuaranteeFund guaranteeFund) {
        sqlSession.update("user.updateGuaranteeFund", guaranteeFund);
    }
    public void updateFundSeller(FundSeller fundSeller) {
    	sqlSession.update("user.updateFundSeller", fundSeller);
    }
    
    
    
    public int deleteUser(String userId) {
        return sqlSession.delete("user.deleteUser", userId);
    }
    public int deleteDirectFund(String userId) {
        return sqlSession.delete("user.deleteDirectFund", userId);
    }
    public int deleteGuaranteeFund(String userId) {
        return sqlSession.delete("user.deleteGuaranteeFund", userId);
    }
    public int deleteFundSeller(String userId) {
    	return sqlSession.delete("user.deleteFundSeller", userId);
    }
}
