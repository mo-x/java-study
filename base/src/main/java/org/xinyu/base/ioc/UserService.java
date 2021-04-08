package org.xinyu.base.ioc;

/**
 * Created by zzqno on 2016-12-26.
 */
public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user){
        userDao.saveUser(user);
    }
}
