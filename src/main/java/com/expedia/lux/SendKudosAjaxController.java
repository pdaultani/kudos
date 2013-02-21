package com.expedia.lux;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.expedia.lux.dao.KudosDataService;
import com.expedia.lux.dao.UserService;
import com.expedia.lux.model.User;

@Controller
public class SendKudosAjaxController {
	
protected static Logger logger = Logger.getLogger(SendKudosAjaxController.class);
@Resource(name="userService")
private UserService userService;

@Resource(name="kudosDataService")
private KudosDataService kudosDataService;

	/**
	 * Handles and retrieves the AJAX Add page
	 */
    @RequestMapping(value = "/send_kudos", method = RequestMethod.GET)
    public String getAjaxSendKudosPage(Model model) {
    	
    	
    	logger.info("Received request to show AJAX, send kudos page");
    	
		User user = userService.getUser(1);	
	      model.addAttribute("username", user.getUsername() );
	     
    	// This will resolve to /WEB-INF/jsp/send_kudos.jsp
    	return "send_kudos";
	}
 
    /**
     * Handles request for sending kudos through ajax
     */
    @RequestMapping(value = "/send_kudos", method = RequestMethod.POST)
    public @ResponseBody String add(@RequestParam(value="kudos_sent_to", required=true) String kudos_sent_to,
    							@RequestParam(value="kudos_sent_from", required=true) String kudos_sent_from,
    							@RequestParam(value="kudos_content", required=true) String kudos_content,
    							Model model) {
		logger.info("Received request to send_kudos");
		
		// Delegate to service to do the actual saving to db later on. and also emailing it out. 
		kudosDataService.add(kudos_sent_to,kudos_sent_from,kudos_content);
		
		String confirm = "Kudos sent!";
		
		// @ResponseBody will automatically convert the returned value into JSON format
	
		return confirm;
	}

}
