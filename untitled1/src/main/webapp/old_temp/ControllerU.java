package com.test.controller;

import org.springframework.security.access.prepost.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by user on 10.09.2015.
 */
@Controller
@RequestMapping("/")
public class ControllerU {

//	@RequestMapping("/")
//	public String home(){
//		return "index";
//	}

	@RequestMapping("/test")
	public String test(){
		return "test";
	}


	@RequestMapping("/upload")
	public String upload(){
		return "view1/view1";
	}


}
