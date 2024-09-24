package com.jisong.demo.portal;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jisong.demo.dao.LoginDAO;
import com.jisong.demo.loginInfo.Role;

@Controller
public class PortalController {
	private @Autowired LoginDAO loginDAO;
	
	@RequestMapping(path ="/login_test" )
	public String visitPage() {
		
		return "Hellow World!";
	}
	@GetMapping("/mypage")
    public String welcome() {
        return "mypage";
    }
	
	@RequestMapping("/login")
    public String findLogin(@RequestParam(name ="username" , required = false) String username , @RequestParam(name = "password",required = false) String password) {
		if(!Objects.isNull(username) && !Objects.isNull(password)) {
			var opt= loginDAO.getLoginInfo(username,password);
			if(opt.isPresent()) {
				//TODO
				var role =opt.get().getRoles();
				if(role != null && !role.isEmpty()) {
					for(Role r :role) {
						System.out.println(r.getName());
					}
				}
				return "mypage";
			}
		}
		return "login";
		
        
    }
}
