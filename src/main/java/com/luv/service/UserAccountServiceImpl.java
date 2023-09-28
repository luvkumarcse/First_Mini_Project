package com.luv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv.entities.UserAccount;
import com.luv.repo.UserAccountRepo;

@Service
public class UserAccountServiceImpl implements UserAccountService{
	@Autowired
	private UserAccountRepo userAccountRepo;

	public String saveOrUpdate(UserAccount userAcc) {
		Integer userId=userAcc.getUserId();
		if(userId==null) {
			userAcc.setActiveSw("Y");
		}
		userAccountRepo.save(userAcc);
		if(userId==null)
		{
		return "user record saved";	
		}else {
			return "user record updated";
		}	
	}
	public List<UserAccount> getAllUserAccounts() {
		
		return userAccountRepo.findAll();
	}
	public UserAccount getUserAcc(Integer userId) {
		Optional<UserAccount> findById = userAccountRepo.findById(userId);
		if(findById.isPresent())
		{
			return findById.get();
		}
		return null;
	}
	public boolean deleteUserAcc(Integer userId) {
	    boolean existsById = userAccountRepo.existsById(userId);
	   if(existsById) {
		   userAccountRepo.deleteById(userId);
		   return true;
	   }
	   return false;
	 }
	
	public boolean updateUserAccStatus(Integer userId, String status) {
		try {
			userAccountRepo.updateUserAccStatus(userId, status);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
