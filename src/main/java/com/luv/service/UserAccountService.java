package com.luv.service;

import java.util.List;

import com.luv.entities.UserAccount;

public interface UserAccountService {
	public String saveOrUpdate(UserAccount userAcc);
	
	public List<UserAccount> getAllUserAccounts();
	
	public UserAccount getUserAcc(Integer userId);
	
	public boolean deleteUserAcc(Integer userId);
	
	public boolean updateUserAccStatus(Integer userId,String status);

}
