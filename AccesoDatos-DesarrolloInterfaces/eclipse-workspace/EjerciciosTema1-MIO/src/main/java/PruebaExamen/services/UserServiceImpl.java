package PruebaExamen.services;

import PruebaExamen.dao.UserDao;
import PruebaExamen.modelo.User;

public class UserServiceImpl implements UserService {
	
	private UserDao dao;

	public UserServiceImpl(UserDao dao) {
		dao = new UserDao();
	}

	@Override
	public User createUser(User user) throws DuplicateUserException, UserException {
		return null;
	}

	@Override
	public void changePassword(Long idUser, String oldPassword, String newPassword)
			throws UserNotFoundException, UserUnauthorizedException, UserException {

	}

	@Override
	public User login(String login, String password)
			throws UserNotFoundException, UserUnauthorizedException, UserException {
		return null;
	}

	@Override
	public User getUser(Long idUser) throws UserNotFoundException, UserException {

		return null;
	}

}
