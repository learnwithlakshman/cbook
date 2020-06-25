package com.lwl.cbook.auth;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="appuser")
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",joinColumns=
            @JoinColumn(name="u_id", referencedColumnName="id"),
            inverseJoinColumns=
            @JoinColumn(name="r_id", referencedColumnName="id"))
	private Set<Role> roles=new HashSet<>();
	
	public void addRole(Role role) {
		this.roles.add(role);
	}
}
