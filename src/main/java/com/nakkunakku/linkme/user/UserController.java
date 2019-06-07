package com.nakkunakku.linkme.user;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nakkunakku.linkme.user.model.RequestAddUser;
import com.nakkunakku.linkme.util.Json;
import com.nakkunakku.linkme.util.LinkMeException;

@RestController
@RequestMapping("/members")
public class UserController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@RequestBody String postBody) {
        try {
            RequestAddUser user = Json.fromJson(postBody, RequestAddUser.class);
            System.out.println(Json.toJson(user));
            return "addUser success2";
        } catch (LinkMeException e) {
            return e.getErrorCode();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public String loginUser() {
        return "loginUser success2";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteUser() {
        return "deleteUser success";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUserInfo() {
        return "updateUserInfo success";
    }
}
