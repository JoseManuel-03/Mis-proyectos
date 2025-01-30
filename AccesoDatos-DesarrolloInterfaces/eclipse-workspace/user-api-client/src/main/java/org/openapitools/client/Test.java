package org.openapitools.client;

import org.openapitools.client.api.UserApiServiceApi;
import org.openapitools.client.model.CreateUserRequest;
import org.openapitools.client.model.User;

public class Test {

	public static void main(String[] args) {
		ApiClient client = new ApiClient();
		client.setBasePath("http://localhost:8080");
		client.setApiKey("pass");
		
		UserApiServiceApi api = new UserApiServiceApi(client);
		
		try {
			User user = api.consultarUsuario(41L);
			System.out.println(user);
			
			CreateUserRequest createUserRequest = new CreateUserRequest();
			createUserRequest.setUsername("ho12334la");
			createUserRequest.setPassword("000");
			createUserRequest.setEmail("holahasdasdola@gmail.com");
			
			User crearuser = api.crearUsuario(createUserRequest);
			System.out.println(crearuser);
		} catch (ApiException e) {
			System.out.println(e.getCode());
			System.out.println(e.getLocalizedMessage());
		}

	}

}
