package com.pi.dh.security.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.pi.dh.domain.model.Pessoa;

import lombok.Getter;

@Getter
public class AuthUser extends User {

private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String nomeCompleto;
	
	public AuthUser(Pessoa usuario, Collection<? extends GrantedAuthority> permissoes) {
		super(usuario.getEmail(), usuario.getPassword(), permissoes);
		
		this.userId = usuario.getPessoaId();
		this.nomeCompleto = usuario.getNome() + " " + usuario.getSobrenome();
	}
	
}
