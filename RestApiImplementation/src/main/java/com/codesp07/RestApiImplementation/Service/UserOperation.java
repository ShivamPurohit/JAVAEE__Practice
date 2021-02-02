package com.codesp07.RestApiImplementation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.codesp07.RestApiImplementation.Repository.UserRepository;
import com.codesp07.RestApiImplementation.model.User;


@Service
public class UserOperation implements UserService{


	@Autowired
	private UserRepository userrepo;
	
	@Autowired
    private JavaMailSender javaMailSender;
	@Override
	public List<User> getUsers(){
		return userrepo.findAll();
	}

	
	
	@Override
	public User getValidUser(String email, String pass) {

        for(User user:userrepo.findAll())
        {
      	  if(user.getEmail().equals(email))
    			{
    				if(user.getPass().equals(pass))
    				{
    					System.out.println("Hello "+user.getUsername());
    					return user;
    				}
    				else
    				{
    					System.out.println("Invaild Password");
    					return null;
    				}
    				
    			}
      	  
        }
		
        System.out.println("Invaild User");
		
		return null;
	}


	@Override
	public User addUser(User user) {
		
	    userrepo.save(user);
	    return user;
	}


	@Override
	public String getValidatedUserEmail(String email) {
		 for(User user:userrepo.findAll())
	        {
	      	  if(user.getEmail().equals(email))
	    			{
	    				
	    				return	user.getUsername() + " exist in database. Your password is " + user.getPass();
	    			
	    			}
	      	  
	        }
			
	      return "Invaild email or user is not registered";
	
	}


	@Override
	public boolean sendEmail(int otp,String email) {
	
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject("Your One Time Password");
        msg.setText("Your OTP is : " + otp);

        javaMailSender.send(msg);
        
       return true;
    }

	

	@Override
	public boolean getValidEmail(String email) {
		
		 for(User user:userrepo.findAll())
	        {
	      	  if(user.getEmail().equals(email))
	    			{
	    				
	    				return	true;
	    			
	    			}
	      	  
	        }
		
		return false;
	}


	@Override
	public String setPass(String pass,int rollno) {
		 for(User user:userrepo.findAll())
	        {
	      	  if(user.getRollno() == rollno)
	    			{
	    				user.setPass(pass);
	    			userrepo.save(user);
	    			}
	      	  
	        }
			return "Password Updated";
	     
	}


	@Override
	public User fetchByUserEmailId(String emailId) {
	
		return userrepo.findByEmail(emailId);
	
	}


	@Override
	public User updatePasswd(User user,String passwd) {
		user.setPass(passwd);
		userrepo.save(user);
		return user;
	}



	@Override
	public User findByRollno(int Rollno) {
		return userrepo.findByrollno(Rollno);
	}
	



//	@Override
//	public User findById(int rollno) {
//		
//		return userrepo.findByUid(rollno);
//	}
//


//	@Override
//	public User fetchByRollno(int rollno) {
//		// TODO Auto-generated method stub
//		return userrepo.fingByRollno(rollno);
//	}


}
