package com.example.count.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class mainController {
	
	private void setCount(HttpSession sesion, int count, String cont) {
		sesion.setAttribute(cont, count);
	}
	
	private int getCount(HttpSession sesion, String cont) {
		Object value = sesion.getAttribute(cont);
		if(value == null) {
			setCount(sesion, 0, cont);
			value = sesion.getAttribute(cont);
		}
		return (int) value;
	}
	
	@RequestMapping("/")
	public String home(HttpSession sesion, HttpSession sesion2) {
		int count = getCount(sesion,"contador");
		int count2 = getCount(sesion2,"contador2");
		setCount(sesion,count+1, "contador");
		setCount(sesion2,count2+2, "contador2");
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String count(HttpSession sesion) {
		if(sesion.getAttribute("contador")==null) {
			setCount(sesion,0,"contador");
		}
		return "count.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/counter";
	}

	@RequestMapping("/counter2")
	public String count2(HttpSession sesion2) {
		if(sesion2.getAttribute("contador2")==null) {
			setCount(sesion2,0,"contador2");
		}
		return "count2.jsp";
	}
	
	@RequestMapping("/reset2")
	public String reset2(HttpSession sesion2) {
		sesion2.invalidate();
		return "redirect:/counter2";
	}
}
