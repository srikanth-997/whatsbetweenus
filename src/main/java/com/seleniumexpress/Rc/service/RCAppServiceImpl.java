package com.seleniumexpress.Rc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleniumexpress.Rc.dao.UserInfoDaoImpl;

@Service("relationAppSeviceimp")
public class RCAppServiceImpl implements RCAppService {
	
	public final String LC_APP_FORMULA="FLAME";
	@Autowired
	private UserInfoDaoImpl userInfoDaoImpl;
	
	
	 
	public String CalculateRelation(String userName, String othersName) {
		int totalCount = (userName + othersName).toCharArray().length;

		int formulacount = LC_APP_FORMULA.toCharArray().length;

		int rem = totalCount % formulacount;
		char resultChar = LC_APP_FORMULA.charAt(rem);

		String appResult = whatsBetweenUs1(resultChar);
         System.out.println(appResult);
		userInfoDaoImpl.saveUserData(userName, othersName, appResult);

		return appResult;


	}

	@Override
	public String whatsBetweenUs1(char resultChar) {

		String result = null;

		if (resultChar == 'F') {
			result = RelationCalculatorConstants.F_CHAR_MEANING;
		} else if (resultChar == 'L') {
			result = RelationCalculatorConstants.L_CHAR_MEANING;
		} else if (resultChar == 'A') {
			result = RelationCalculatorConstants.A_CHAR_MEANING;
		} else if (resultChar == 'M') {
			result = RelationCalculatorConstants.M_CHAR_MEANING;
		} else if (resultChar == 'E') {
			result = RelationCalculatorConstants.E_CHAR_MEANING;
		}
		return result;
	}

}



