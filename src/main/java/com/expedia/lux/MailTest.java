package com.expedia.lux;

import java.sql.Array;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.expedia.lux.dao.KudosMailService;

public class MailTest {
	
	public static void main( String[] args )
    {
    	ApplicationContext context = 
             new ClassPathXmlApplicationContext("mail-config.xml");
 
    	KudosMailService km = (KudosMailService) context.getBean("KudosMailService");
        km.sendMail("from@no-spam.com",
    		   "priyankadaultani@gmail.com",
    		   "Testing123", 
    		   "Testing only \n\n Hello Spring Email Sender");
		
		
    }

}
