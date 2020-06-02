package projetFinalBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import projetFinalBoot.entity.Login;
import projetFinalBoot.repository.LoginRepository;


@Service
public class ConsoleService implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	LoginRepository loginRepository;
	
	@Override
	public void run(String... args) throws Exception {
		for(Login login:loginRepository.findAll()) {
			login.setPassword(passwordEncoder.encode(login.getPassword()));
			loginRepository.save(login);
		}
		
	}


}
