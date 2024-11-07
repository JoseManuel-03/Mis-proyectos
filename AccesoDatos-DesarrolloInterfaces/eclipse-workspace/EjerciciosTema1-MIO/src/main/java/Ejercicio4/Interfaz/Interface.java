package Ejercicio4.Interfaz;

import Ejercicio4.Modelo.Usuario;
import Ejercicio4.Services.ErrorCambiandoPasswordException;
import Ejercicio4.Services.HayUsuariosException;
import Ejercicio4.Services.NoHayUsuariosException;

public interface Interface {

	public void changePass(Long idUser, String password, String newPassword) throws ErrorCambiandoPasswordException;

	public Usuario registrer(Usuario user) throws HayUsuariosException;

	public Usuario login(String login, String password) throws NoHayUsuariosException;

	public Usuario consult(Long idUser) throws NoHayUsuariosException;

}
