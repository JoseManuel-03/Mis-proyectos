package ejercicios.ejercicio05.test;

import org.apache.commons.codec.digest.DigestUtils;

public class Test {

	public static void main(String[] args) {
		String password = "bigotitos";
		String passwordCifrada = DigestUtils.sha256Hex(password);
		System.out.println(passwordCifrada);
	}

}
