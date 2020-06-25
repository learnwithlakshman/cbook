package com.lwl.cbook.auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser,Long> {
	AppUser findByUsername(String email);

}
