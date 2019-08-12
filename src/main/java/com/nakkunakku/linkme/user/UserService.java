package com.nakkunakku.linkme.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nakkunakku.linkme.user.model.DirectFund;
import com.nakkunakku.linkme.user.model.GuaranteeFund;
import com.nakkunakku.linkme.user.model.RequestAddUser;
import com.nakkunakku.linkme.user.model.RequestDeleteUser;
import com.nakkunakku.linkme.user.model.RequestUpdateUser;
import com.nakkunakku.linkme.user.model.RequestUserInfo;
import com.nakkunakku.linkme.user.model.ResponseUserInfo;
import com.nakkunakku.linkme.user.model.User;
import com.nakkunakku.linkme.util.Json;
import com.nakkunakku.linkme.util.LinkMeException;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String getCurrentDateTime() {
        return userRepository.getLocalTime();
    }

    @Transactional
    public String addUser(RequestAddUser requestAddUser) {
        User user = new User(requestAddUser);
        userRepository.addUser(user);

        if (user.getUserType().equals(User.UserType.GuaranteeFund.name())) {
            GuaranteeFund guaranteeFund = new GuaranteeFund(requestAddUser);
            userRepository.addGuaranteeFund(guaranteeFund);
        } else if (user.getUserType().equals(User.UserType.DirectFund.name())) {
            DirectFund directFund = new DirectFund(requestAddUser);
            userRepository.addDirectFund(directFund);
        } else {
            // throw exception
            return null;
        }

        return "success";
    }

    @Transactional
    public String deleteUser(RequestDeleteUser requestAddUser) {
        User user = userRepository.findUser(requestAddUser.getId());
        if (user == null) {
            return "user no exist";
        }

        if (!user.getPasswd().equals(requestAddUser.getPasswd())) {
            return "wrong user passwd";
        }

        if (user.getUserType().equals(User.UserType.GuaranteeFund.name())) {
            GuaranteeFund guaranteeFund = userRepository.findGuaranteeFund(user.getId());
            if (guaranteeFund == null) {
                return "user no exist";
            }

            userRepository.deleteGuaranteeFund(guaranteeFund.getUserId());
        } else if (user.getUserType().equals(User.UserType.DirectFund.name())) {
            DirectFund directFund = userRepository.findDirectFund(user.getId());
            if (directFund == null) {
                return "user no exist";
            }

            userRepository.deleteDirectFund(directFund.getUserId());
        } else {
            return "user no exist";
        }

        userRepository.deleteUser(user.getId());

        return "success";
    }
    
    @Transactional
    public String findUser(RequestUserInfo requestUserInfo) throws LinkMeException {
        ResponseUserInfo responseUserInfo = new ResponseUserInfo();
        User user = userRepository.findUser(requestUserInfo.getId());
        if (user == null) {
            return "user no exist";
        }

        if (!user.getPasswd().equals(requestUserInfo.getPasswd())) {
            return "wrong user passwd";
        }
        
        responseUserInfo.setId(user.getId());
        responseUserInfo.setEmail(user.getEmail());
        responseUserInfo.setUserType(user.getUserType());
        
        if (user.getUserType().equals(User.UserType.GuaranteeFund.name())) {
            GuaranteeFund guaranteeFund = userRepository.findGuaranteeFund(user.getId());
            if (guaranteeFund == null) {
                return "user no exist";
            }
            
            responseUserInfo.setGuaranteeFund(guaranteeFund);
        } else if (user.getUserType().equals(User.UserType.DirectFund.name())) {
            DirectFund directFund = userRepository.findDirectFund(user.getId());
            if (directFund == null) {
                return "user no exist";
            }
            
            responseUserInfo.setDirectFund(directFund);
        } else {
            return "user no exist";
        }
        
        return Json.toJson(responseUserInfo);
    }
    
    @Transactional
    public String updateUser(RequestUpdateUser requestUpdateUser) {
        User user = userRepository.findUser(requestUpdateUser.getId());
        if (user == null) {
            return "user no exist";
        }
        
        if (!user.getPasswd().equals(requestUpdateUser.getPasswd())) {
            return "invalid password";
        }
        
        User newUser = new User(requestUpdateUser);
        userRepository.updateUser(newUser);
        
        if (requestUpdateUser.getUserType().equals(User.UserType.GuaranteeFund.name())) {
            GuaranteeFund guaranteeFund = new GuaranteeFund(requestUpdateUser);
            userRepository.updateGuaranteeFund(guaranteeFund);
            
        } else if (requestUpdateUser.getUserType().equals(User.UserType.DirectFund.name())) {
            DirectFund directFund = new DirectFund(requestUpdateUser);
            userRepository.updateDirectFund(directFund);
            
        } else {
            return "user no exist";
        }
        
        return "success";
    }
}
