package com.somebunnycodes.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.somebunnycodes.bookclub.models.LoginUser;
import com.somebunnycodes.bookclub.models.User;
import com.somebunnycodes.bookclub.services.UserService;

@Controller
public class UserController {
	
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String index(HttpSession session, Model model) {
    	User user = (User)session.getAttribute("user");
    	if (user != null) {
    		return "redirect:/books";
    	}
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
 
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
    	User createdUser = userService.register(newUser, result);
        if (createdUser == null) {
        	model.addAttribute("newUser", newUser);
        	model.addAttribute("newLogin", new LoginUser());
        	return "index.jsp";
        }   
        session.setAttribute("user", createdUser);
        return "redirect:/books";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
    	User loggedInUser = userService.login(newLogin, result);
        if (loggedInUser == null) {
        	model.addAttribute("newUser", new User());
        	model.addAttribute("newLogin", newLogin);
        	return "index.jsp";
        }   
        session.setAttribute("user", loggedInUser);
        return "redirect:/books";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.setAttribute("user", null);
    	return "redirect:/";
    }
}

