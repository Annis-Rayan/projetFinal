package projetFinalBoot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import projetFinalBoot.entity.Login;
import projetFinalBoot.repository.LoginRepository;


@Service
public class AuthService implements UserDetailsService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//TODO verifier
		Login l = new Login();
		l.setLogin(username);
		Example<Login> example = Example.of(l);
		Optional<Login> opt = loginRepository.findOne(example);
		if (!opt.isPresent()) {
			throw new UsernameNotFoundException("utlisateur inconnu");
		}
		UtilisateurLogin user = new UtilisateurLogin(opt.get());
		return user;
	}

}
