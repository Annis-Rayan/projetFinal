package projetFinalBoot.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import projetFinalBoot.entity.views.Views;

@Entity
@Table(name = "login")
@SequenceGenerator(name="seqlogin",sequenceName = "seq_login",initialValue=100,allocationSize=1)
public class Login {
	
	@JsonView(Views.Common.class)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqlogin")
	@Column(name="id_login", nullable = false)
	private Integer id;
	
	@JsonView(Views.Common.class)
	@Column(name = "username", length = 100, nullable = false)
	private String login;
	
	@Column(name = "password", length = 100, nullable = false)
	private String password;
	
	private boolean enable;
	
	@JsonView(Views.Common.class)
	@OneToMany(mappedBy = "login")
	private Set<LoginRole> roles;
	
	@JsonView(Views.Common.class)
	
	@OneToOne
	private Utilisateur utilisateur;
	
	
	public Login() {

	}
	
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Set<LoginRole> getRoless() {
		return roles;
	}
	
	public LoginRole getRoles() {
		return (LoginRole)roles.toArray()[0];
	}

	public void setRoles(Set<LoginRole> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

}
