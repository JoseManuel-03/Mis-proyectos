package ceu.dam.ad.users.api;

import lombok.Data;

@Data
public class ChangePasswordRequest {
	
	private Long id;
	private String passwordOld;
	private String passwordNew;

}
