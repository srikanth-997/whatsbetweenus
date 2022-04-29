package com.seleniumexpress.Rc.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;




@Entity
@Table(name = "UserInfoEntity")
@EnableWebMvc

public class UserInfoEntity {

	

	@Id
	@Column(name="s_No")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int s_No;
	private String userName;
	private String othersName;

	private String appResult;
	public UserInfoEntity() {
		super();
		System.out.println("UserInfoENtity excuted");
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOthersName() {
		return othersName;
	}

	public void setOthersName(String othersName) {
		this.othersName = othersName;
	}

	public String getAppResult() {
		return appResult;
	}

	public void setAppResult(String appResult) {
		this.appResult = appResult;
	}

	
}
