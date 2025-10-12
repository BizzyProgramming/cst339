package com.gcu.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UsersRepository;

@Service
public class UsersDataService implements UsersDataInterface<UserEntity>, DataAccessInterface<UserEntity> {

	private final UsersRepository usersRepository;
	
	public UsersDataService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}
	
	public UserEntity findByUsername(String username) {
		return usersRepository.findByUsername(username);
	}

	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserEntity findByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
