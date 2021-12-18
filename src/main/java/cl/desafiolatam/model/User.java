package cl.desafiolatam.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;

import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, unique = true)
	private Long id;
	
	@NotEmpty(message="Campo obligatorio")
	private String username;
	@NotEmpty(message="Campo obligatorio")
	@Email
	private String email;
	@NotEmpty(message="Campo obligatorio")
	private String password;
	@NotEmpty(message="Campo obligatorio")
	private String passwordConfirmation;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
//	@OneToMany(mappedBy = "tbd", fetch = FetchType.LAZY)
//	private List<Show> userShow;
//	
//	@OneToMany (mappedBy = "tbd", fetch = FetchType.EAGER)
//	private List<Rating> ratings;

}
