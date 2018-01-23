package com.clps.jPet.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.clps.jPet.pojo.Account;
import com.clps.jPet.pojo.Profile;
import com.clps.jPet.pojo.Signon;
import com.clps.jPet.service.RegisterService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户注册
 * 
 * @author zhangguoliang
 */
@Controller
@ParentPackage("json-default")
public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(RegisterAction.class);

	@Autowired
	private RegisterService registerService;

	private Account account;
	private Profile profile;
	private Signon signon;

	/**
	 * 注册用户、添加账户表、登陆表、用户广告表
	 * 
	 * @return /account/SignonForm.jsp
	 */
	@Action(value = "insertAction", results = { @Result(name = "success", location = "/account/SignonForm.jsp") })
	public String insert() {

		if (profile.getBanneropt() == null) {
			profile.setBanneropt(0);
		}
		if (profile.getMylistopt() == null) {
			profile.setMylistopt(0);
		}

		profile.setUserid(signon.getUsername());
		account.setUserid(signon.getUsername());
		account.setLastname("Liang");
		registerService.insertAccount(account);
		registerService.insertProfile(profile);
		registerService.insertSigno(signon);

		return "success";
	}

	public RegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Signon getSignon() {
		return signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}
}
