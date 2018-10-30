package com.jcg.spring.log4j;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	private Logger logger = Logger.getLogger(TestController.class);

	@RequestMapping(value = {"/", "hello"}, method = RequestMethod.GET)
	public @ResponseBody String helloWorld() {

		
		logger.info("This Is An Info Log Entry ......!");
		logger.error("This Is An Error Log Entry ......!");
		return "hello";
	}
}