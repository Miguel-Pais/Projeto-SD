package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	List<User> findByEmail(String email);

}
