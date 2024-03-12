package com.full.app.Services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.full.app.Exception.UserNotFoundException;
import com.full.app.Exception.userAleradyExsitsException;
import com.full.app.Modeles.User;
import com.full.app.Repositorys.UserRepository;

@Service
public class UserServiceImpl  implements UserInterface {

	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User AddUser(User user) {
		if(userAleradyExsits(user.getEmail())) {
			throw new userAleradyExsitsException("user Already exsist"+user.getEmail());
		}
		
		return userRepository.save(user);
	}

	private boolean userAleradyExsits(String email) {
		return userRepository.findByEmail(email).isPresent();
	}

	@Override
	public List<User> GetAlluser() {
		return userRepository.findAll();
	}

	@Override
	public User GetUserByid(Long id) {
		return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("Sorry User not Exsist"));
		
	}

	@Override
	public User UpdateUser(User user, long id) {
		return userRepository.findById(id).map(u ->{ 
			u.setFirstname(user.getFirstname());
			u.setLastname(user.getLastname());
			u.setEmail(user.getEmail());
			u.setDepartemnt(user.getDepartemnt());
			return userRepository.save(u);
		} ).orElseThrow(()-> new UserNotFoundException("Sorry User not Exsist"));
	}

	@Override
	public void DeleteUser(Long id) {
          if(!userRepository.existsById(id)) {
        	  throw new  UserNotFoundException("Sorry User not Exsist");
         }
         // userRepository.deleteById(id);
		
		User user = userRepository.findById(id).get();
          //.orElseThrow(() -> new  ResponseStatusException (HttpStatus.NOT_FOUND, "User introuvable avec l'identifiant " + id)); 
     	userRepository.delete(user);

	}

}
