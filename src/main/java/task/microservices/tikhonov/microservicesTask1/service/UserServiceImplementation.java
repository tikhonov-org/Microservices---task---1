package task.microservices.tikhonov.microservicesTask1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task.microservices.tikhonov.microservicesTask1.dao.UserDaoImplementation;
import task.microservices.tikhonov.microservicesTask1.model.User;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    private UserDaoImplementation userDaoImplementation;

    @Autowired
    public UserServiceImplementation(UserDaoImplementation userDaoImplementation) {
        this.userDaoImplementation = userDaoImplementation;
    }

    @Override
    public List<User> getUsers(){
        return userDaoImplementation.getUsers();
    }

    @Override
    public User getUser(int id){
        return userDaoImplementation.getUser(id);
    }

    @Override
    @Transactional
    public void addUser(User user){
        userDaoImplementation.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(int id, User user){
        userDaoImplementation.updateUser(id, user);
    }

    @Override
    @Transactional
    public void deleteUser(int id){
        userDaoImplementation.deleteUser(id);
    }
}
