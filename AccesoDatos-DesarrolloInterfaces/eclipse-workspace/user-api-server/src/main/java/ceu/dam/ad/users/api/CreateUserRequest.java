package ceu.dam.ad.users.api;

import lombok.Data;

@Data
public class CreateUserRequest {

	private String username;
	private String password;
	private String email;
	
}
