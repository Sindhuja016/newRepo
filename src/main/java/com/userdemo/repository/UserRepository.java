package com.userdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.userdemo.model.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {
	
}
