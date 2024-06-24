package com.userdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userdemo.model.UserModel;
import com.userdemo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository usersrepository;
	
	public List<UserModel>getAllUsers(){
		List<UserModel>users=new ArrayList<UserModel>();
	    usersrepository.findAll().forEach(users1->users.add(users1));
	    return users;
	}
	public Optional<UserModel> getUserById(Integer id) {
		return usersrepository.findById(id);
	}
	public List<UserModel> saveOrUpdateAll(List<UserModel> users) {
        return (List<UserModel>) usersrepository.saveAll(users);
    }

	
	public void delete(Integer id) {
		usersrepository.deleteById(id);
	}
	
	public UserModel updateUserById(UserModel updatedUser) {
        return usersrepository.save(updatedUser);
    }
	

}
