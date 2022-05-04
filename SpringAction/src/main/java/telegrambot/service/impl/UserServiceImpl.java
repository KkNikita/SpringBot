package telegrambot.service.impl;

import telegrambot.dao.UserDao;
import telegrambot.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void registerUser(String surname, String name){
        userDao.registerUser(surname,name);
    }

}
