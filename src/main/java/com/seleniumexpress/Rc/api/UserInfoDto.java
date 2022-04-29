package com.seleniumexpress.Rc.api;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
public class UserInfoDto {

	@NotBlank(message = "* Your Name can't be blank")
	private String userName;

	@NotNull(message = "* OthersName name must not be null")
	@Size(min = 2, max = 15, message = "* OthersName Name must be atleast 2 characters")
	private String othersName;

	@AssertTrue(message = "* You must agree to use our app")
	private boolean termsAndConditions;

	private String appResult;

	public String getAppResult() {
		return appResult;
	}

	public void setAppResult(String appResult) {
		this.appResult = appResult;
	}

	public boolean isTermsAndConditions() {
		return termsAndConditions;
	}

	public void setTermsAndConditions(boolean termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
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

	@Override
	public String toString() {
		return "UserInfoDto [userName=" + userName + ", othersName=" + othersName + ", termsAndConditions="
				+ termsAndConditions + "]";
	}

}
