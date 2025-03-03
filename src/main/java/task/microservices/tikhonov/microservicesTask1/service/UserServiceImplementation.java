package task.microservices.tikhonov.microservicesTask1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task.microservices.tikhonov.microservicesTask1.dao.UserDao;
import task.microservices.tikhonov.microservicesTask1.model.User;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImplementation(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUsers(){
        return userDao.getUsers();
    }

    @Override
    public User getUser(int id){
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public void addUser(User user){
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(int id, User user){
        userDao.updateUser(id, user);
    }

    @Override
    @Transactional
    public void deleteUser(int id){
        userDao.deleteUser(id);
    }
}
