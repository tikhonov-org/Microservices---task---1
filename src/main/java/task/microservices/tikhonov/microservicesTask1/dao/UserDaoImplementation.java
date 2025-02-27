package task.microservices.tikhonov.microservicesTask1.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import task.microservices.tikhonov.microservicesTask1.model.User;
import java.util.List;

@Repository
public class UserDaoImplementation implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        User curUser = entityManager.find(User.class, id);
        if (curUser == null) {
            return;
        }

        curUser.setName(user.getName());
        curUser.setAge(user.getAge());
        curUser.setEmail(user.getEmail());
        entityManager.merge(curUser);
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        if(user != null) {
            entityManager.remove(user);
        }
    }
}
