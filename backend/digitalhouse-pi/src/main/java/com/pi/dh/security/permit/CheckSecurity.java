package com.pi.dh.security.permit;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

public @interface CheckSecurity {
	public @interface Pessoa {
		// SA01
				@PreAuthorize("isAuthenticated() and " +
						"hasAuthority('SA01')")
				@Retention(RUNTIME)
				@Target(METHOD)
				public @interface PodeConsultar {
				}
				
		// SA02
		@PreAuthorize("isAuthenticated() and " +
				"hasAuthority('SA02')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeEditar {
		}	
	}
	
	public @interface Administrador {
		// SA01 e SA04
		@PreAuthorize("isAuthenticated() and " +
				"hasAuthority('SA01')" + " and " + "hasAuthority('SA04')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultar {
		}	
		
		// SA02 e SA04
		@PreAuthorize("isAuthenticated() and " +
			"hasAuthority('SA02')" + " and " + "hasAuthority('SA04')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeEditar {
		}	
	}
	
	public @interface Aluno {
		// SA01 e SA05
		@PreAuthorize("isAuthenticated() and " +
				"hasAuthority('SA01')" + " and " + "hasAuthority('SA05')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultar {
		}	
		
		// SA02 e SA05
		@PreAuthorize("isAuthenticated() and " +
			"hasAuthority('SA02')" + " and " + "hasAuthority('SA05')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeEditar {
		}	
	}
	
	public @interface Professor {
		// SA01 e SA03
		@PreAuthorize("isAuthenticated() and " +
				"hasAuthority('SA01')" + " and " + "hasAuthority('SA03')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultar {
		}	
		
		// SA02 e SA03
		@PreAuthorize("isAuthenticated() and " +
			"hasAuthority('SA02')" + " and " + "hasAuthority('SA03')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeEditar {
		}	
	}
	
}