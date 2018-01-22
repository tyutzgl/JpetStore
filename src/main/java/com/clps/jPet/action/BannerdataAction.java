package com.clps.jPet.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.clps.jPet.pojo.Bannerdata;
import com.clps.jPet.pojo.Profile;
import com.clps.jPet.pojo.Signon;
import com.clps.jPet.service.BannerdataService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@ParentPackage("json-default")
public class BannerdataAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    @Autowired
    private BannerdataService bannerdataService;

    private Bannerdata bannerdata;
    private Profile profile;
    private Signon signon;


    /**
     * 查询Banner信息，获取导航栏
     * queryBannerdataAction
     *
     * @return json
     */
    @Action(value = "queryBannerdataAction", results = @Result(name = "success", type = "json"))
    public String queryBannerdata() {

        bannerdata = bannerdataService.querybanner(signon.getUsername());
        profile = bannerdataService.queryMyListOpf(signon.getUsername());
        return "success";

    }

    // -----------------------------------------------------------
    // 以下为get和set方法，请勿乱动
    public Bannerdata getBannerdata() {
        return bannerdata;
    }

    public void setBannerdata(Bannerdata bannerdata) {
        this.bannerdata = bannerdata;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @JSON(serialize = false)
    public Signon getSignon() {
        return signon;
    }

    public void setSignon(Signon signon) {
        this.signon = signon;
    }

}
