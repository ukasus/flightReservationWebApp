package com.example.ujjawal.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

import com.example.ujjawal.abstractentities.abstractItems;
@Entity
public class Role extends abstractItems implements GrantedAuthority{
	
	private String name;
	@ManyToMany(mappedBy="roles")
	private Set<user> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAuthority() {
		
		return name;
	}
	

}
