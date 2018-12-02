package com.xyc.crm.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xyc.crm.domain.User;
import com.xyc.crm.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
/**
 * 用户管理的Action类
 * @author YuChen_Xu
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	
	//模型驱动所使用的对象
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	
	//注入Service
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 用户注册的方法：regist
	 * @return
	 */
	public String regist() {
		userService.regist(user);
		return LOGIN;
	}
	
	/**
	 * 用户登录的方法
	 * @return
	 */
	public String login() {
		User existUser = userService.login(user);
		if(existUser==null) {
			//登陆失败
			//添加错误信息
			this.addActionError("用户名或密码错误");
			return LOGIN;
		}else {
			//登录成功
			//ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			ActionContext.getContext().getSession().put("existUser", existUser);
			return SUCCESS;
		}
	}
	
	public String findAllUser() throws IOException {
		List<User> list = userService.findAll();
		//将list转为json
		JSONArray jsonArray = JSONArray.fromObject(list);
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
		return NONE;
	}
}
