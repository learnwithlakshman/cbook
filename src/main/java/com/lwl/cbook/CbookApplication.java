package com.lwl.cbook;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CbookApplication implements CommandLineRunner {
//	@Autowired
//	private RoleRepo roleRepo;
//	@Autowired
//	private AppUserRepo appUserRepo;
//
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(CbookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		roleRepo.deleteAll();
//		appUserRepo.deleteAll();
//
//		Role role = new Role();
//		role.setRole("USER");
//		role = roleRepo.save(role);
//
//		AppUser appUser = new AppUser();
//		appUser.setUsername("user");
//		appUser.setPassword(passwordEncoder.encode("user@123"));
//		appUser.addRole(role);
//		appUserRepo.save(appUser);

	}

}
