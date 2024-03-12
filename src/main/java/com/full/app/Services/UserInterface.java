package com.full.app.Services;

import java.util.List;

import com.full.app.Modeles.User;

public interface UserInterface {
	
	
	
	User AddUser(User user);
	
	List<User> GetAlluser();
	
    User GetUserByid(Long id);
    
    User UpdateUser(User user,long id);
    
    void DeleteUser(Long id);
	

}
