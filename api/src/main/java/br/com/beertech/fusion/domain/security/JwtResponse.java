package br.com.beertech.fusion.domain.security;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private final String jwtTimeCreated;

	public JwtResponse(String jwttoken,String jwtTimeCreated) {
		this.jwttoken = jwttoken;
		this.jwtTimeCreated = jwtTimeCreated;
	}

	public String getToken() {

		return this.jwttoken;
	}
}