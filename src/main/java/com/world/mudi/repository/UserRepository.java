package com.world.mudi.repository;

import com.world.mudi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, String> {
	UserModel findByUsername(String username);
}