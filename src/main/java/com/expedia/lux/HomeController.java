package com.expedia.lux;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expedia.lux.dao.KudosDataService;
import com.expedia.lux.dao.UserService;
import com.expedia.lux.model.KudosData;
import com.expedia.lux.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="kudosDataService")
	 private KudosDataService kudosDataService;
	
	@Resource(name="userService")
	 private UserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		//We will connect with the active directory here and assume that we 
		//have a received the details for the current user. 
//		ApplicationContext context = 
//	             new ClassPathXmlApplicationContext("datasource.xml");
//
//	      UserJDBCTemplate userJDBCTemplate = 
//	      (UserJDBCTemplate)context.getBean("userJDBCTemplate");
//	      
//	      User user = userJDBCTemplate.getUser(1);
	      
		  User user = userService.getUser(1);	
	      model.addAttribute("username", user.getUsername() ); //hardcoding for now.
	      
	      //Retreiving list of kudos for particular team
	      
	      List<KudosData> kudos = kudosDataService.getAll(user.getId());
	      
	      // Attach persons to the Model
	      model.addAttribute("kudos", kudos);
	      logger.debug(kudos.toString());
		return "home";
	}
	
	@RequestMapping(value="/download_kudos_pdf")
	public ModelAndView showPDF() {
		User user = userService.getUser(1);	
		List<KudosData> kudos = kudosDataService.getAll(user.getId());
			
	        return new ModelAndView("HelloWorldPdfView", "kudos", kudos);
	}     
}
