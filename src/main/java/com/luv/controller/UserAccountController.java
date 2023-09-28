package com.luv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv.entities.UserAccount;
import com.luv.service.UserAccountService;

@Controller
public class UserAccountController {
	@Autowired
	private UserAccountService userAccountService;
	@GetMapping("/")
	public String index(Model model)
	{
		model.addAttribute("user",new UserAccount());
		return "index";
	}
	
	@PostMapping("/save-user")
	public String handleSubmitBtn(@ModelAttribute("user") UserAccount userAcc,Model model)
	{
		//userAcc.setActiveSw("Y");
		String msg = userAccountService.saveOrUpdate(userAcc);
		model.addAttribute("msg",msg);
		model.addAttribute("user", new UserAccount());
		return "index";
		
	}
	@GetMapping("/users")
	public String viewUsers(Model model)
	{
		 List<UserAccount> userList = userAccountService.getAllUserAccounts();
		 model.addAttribute("users", userList);
		return "view-users";
		
	}
	@GetMapping("/edit")
	public String editUser(@RequestParam("id") Integer id, Model model) {
	    UserAccount user = userAccountService.getUserAcc(id);
	    model.addAttribute("user", user);
	    return "index";	
	}
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("id") Integer id,Model m)
	{
    userAccountService.deleteUserAcc(id);
    m.addAttribute("msg", "User delete successfully");
	return "forward:/users";
		
	}
	@GetMapping("/update")
	public String changeAccStatus(@RequestParam("id") Integer userId,
		                        	@RequestParam("status")String status,Model model)
	{
		if("Y".equals(status)) {
			model.addAttribute("msg", "User account activated");
			
		}else {
			model.addAttribute("msg", "User account De-activated");
		}
		userAccountService.updateUserAccStatus(userId, status);
		
		return "forward:/users";
		
	}

}
