package com.clps.jPet.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.clps.jPet.pojo.Account;
import com.clps.jPet.pojo.Profile;
import com.clps.jPet.pojo.Signon;
import com.clps.jPet.service.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户登录、登录验证、查询用户信息
 *
 * @author zhangguoliang
 */
@Controller
@ParentPackage("json-default")
public class LoginAction extends ActionSupport {

    @Autowired
    private LoginService loginService;

    private static final long serialVersionUID = 1L;
    private static Log log = LogFactory.getLog(LoginAction.class);

    private Signon signon;
    private Integer result;
    private Profile profile;
    private Account account;

    /**
     * 用户登录，返回result=1表示登录成功
     *
     * @return SUCCESS
     */
    @Action(value = "loginAction", results = @Result(name = "success", type = "json"))
    public String login() {
        result = loginService.userLogin(signon.getUsername(), signon.getPassword());
        if (result == 1) {
            log.info("登录成功");
            ActionContext.getContext().getSession().put("userid", signon.getUsername());
        } else {
            log.info("用户名或密码错误");
        }
        return SUCCESS;
    }

    /**
     * 查询用户信息
     *
     * @return SUCCESS
     */
    @Action(value = "queryInfoByUserAction", results = {
            @Result(name = "success", location = "/account/EditAccountForm.jsp")})
    public String queryInfoByUser() {
        signon = loginService.querySignon(signon.getUsername());
        profile = loginService.queryProfile(signon.getUsername());
        account = loginService.queryAccount(signon.getUsername());
        return "success";
    }

    /**
     * 用户登出，清除session
     *
     * @return SUCCESS
     */
    @Action(value = "dropUserAction", results = {@Result(name = "success", location = "/account/SignonForm.jsp")})
    public String drop() {
        ActionContext.getContext().getSession().remove("userid");
        return "success";
    }

    @JSON(serialize = false)
    public Signon getSignon() {
        return signon;
    }

    public void setSignon(Signon signon) {
        this.signon = signon;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @JSON(serialize = false)
    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @JSON(serialize = false)
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
