package com.alk.core.util;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alk.core.security.dto.NewUser;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;


@Service
public class SendGreetingEmail {


	@Value("${email}")
	private String emailSender;
	
	public Response sendEmail(NewUser user){
		
		
		Email from= new Email(emailSender);
		Email to= new Email(user.getEmail());
		String subject = "Welcome to Disney World Api";
		Content content = new Content("text/plain",
				"Hi " + user.getUsername()
	    		+ ", now you can explore the information of your characters from your favorite movies and series");
	    Mail mail = new Mail(from, subject, to, content);
	    
	    SendGrid sg= new SendGrid(System.getenv("SENDGRIND.API.KEY"));
	    
	    Request request = new Request();
	    Response response = null;
	    
	    try {
	    	request.setMethod(Method.POST);
		      request.setEndpoint("mail/send");
		      request.setBody(mail.build());
		      response = sg.api(request);
		} catch (IOException  e) {
			  System.out.println(e.getMessage());
		}
	    
	    return response;
	    
		
	}
}
