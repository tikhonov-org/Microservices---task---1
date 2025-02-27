package task.microservices.tikhonov.microservicesTask1.service;

import task.microservices.tikhonov.microservicesTask1.model.User;
import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUser(int id);

    void addUser(User user);

    void updateUser(int id, User user);

    void deleteUser(int id);

}
