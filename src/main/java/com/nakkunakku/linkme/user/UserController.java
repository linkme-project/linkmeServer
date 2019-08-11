package com.nakkunakku.linkme.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nakkunakku.linkme.user.model.RequestAddUser;
import com.nakkunakku.linkme.user.model.RequestDeleteUser;
import com.nakkunakku.linkme.user.model.RequestUserInfo;
import com.nakkunakku.linkme.util.Json;
import com.nakkunakku.linkme.util.LinkMeException;

@RestController
@RequestMapping("/members")
public class UserController {

	@Autowired
	private UserService userService;
	
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public String addUser(@RequestBody String postBody) {
        try {
            RequestAddUser requestAddUser = Json.fromJson(postBody, RequestAddUser.class);
            System.out.println(Json.toJson(requestAddUser));
            
            return userService.addUser(requestAddUser);
        } catch (LinkMeException e) {
            return e.getErrorCode();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public String loginUser(@RequestBody String postBody) {
        try {
            RequestAddUser requestAddUser = Json.fromJson(postBody, RequestAddUser.class);
            System.out.println(Json.toJson(requestAddUser));
            
            return userService.addUser(requestAddUser);
        } catch (LinkMeException e) {
            return e.getErrorCode();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteUser(@RequestBody String postBody) {
        try {
            RequestDeleteUser requestDeleteUser = Json.fromJson(postBody, RequestDeleteUser.class);
            System.out.println(Json.toJson(requestDeleteUser));
            
            return userService.deleteUser(requestDeleteUser);
        } catch (LinkMeException e) {
            return e.getErrorCode();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUserInfo() {
        return "updateUserInfo does not support";
    }
    
    @RequestMapping(value = "/info", method = {RequestMethod.POST, RequestMethod.GET})
    public String userInfo(@RequestBody String postBody) {
        try {
            RequestUserInfo requestUserInfo = Json.fromJson(postBody, RequestUserInfo.class);
            System.out.println(Json.toJson(requestUserInfo));
            
            return userService.findUser(requestUserInfo);
        } catch (LinkMeException e) {
            return e.getErrorCode();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
