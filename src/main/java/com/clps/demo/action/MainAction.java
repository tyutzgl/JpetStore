package com.clps.demo.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.clps.demo.domain.User;
import com.clps.demo.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhangguoliang
 * @date 2018-01-08 11:03
 */
@Controller
@ParentPackage("json-default")
@Namespace("/demo")
public class MainAction extends ActionSupport {

	@Autowired
	private UserService userService;

	private Map<String, Object> dataMap;

	@Override
	@Action(value = "demo", results = { @Result(name = "success", location = "/index.jsp") })
	public String execute() throws Exception {
		System.out.println("struts搭建成功");
		String str = userService.userServiceDemo();
		System.out.println(str);
		return SUCCESS;
	}

	@Action(value = "findUser", results = @Result(name = "success", type = "json", params = { "root", "dataMap" }))
	public String findUser() throws Exception {
		dataMap = new HashMap<String, Object>();
		User user = userService.getUserById(1);
		System.out.println("action中user：" + user.toString());
		dataMap.put("user", user);
		dataMap.put("success", true);
		return SUCCESS;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

}
