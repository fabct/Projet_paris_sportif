package com.projet_paris_sportif.repository;

import com.projet_paris_sportif.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,String>{
	
}

