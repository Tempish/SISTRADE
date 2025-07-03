package ac.cr.ucr.SISTRADE.service;

import ac.cr.ucr.SISTRADE.model.User;
import ac.cr.ucr.SISTRADE.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public User saveUser(User user){
        return this.userRepository.save(user);
    }

    public Optional<User> findUserById(Integer id){
        return this.userRepository.findById(id);
    }

    public List<User> findAllUsers(){
        return this.userRepository.findAll();
    }

    public void deleteUserById(Integer id){
        this.userRepository.deleteById(id);
    }

    public User editUser(Integer id, User user){
        Optional<User>  userOptional = this.userRepository.findById(id);
        if (userOptional.isEmpty()) {
            return new User();
        }

        this.userRepository.deleteById(id);
        return this.userRepository.save(user);

    }

    public Optional<User> loginUser(String password, String name) {

        Optional<User> userOpt = this.userRepository.findByName(name);
        if (userOpt.isPresent()){

            User user = userOpt.get();

            if (user.getName().equals(name) && user.getPassword().equals(password)){

                return Optional.of(user);

            }

            return Optional.empty();

        }

        return this.userRepository.findByPassword(password);
    }


    public Optional<User> findUserByName(String name) {
        return this.userRepository.findByName(name);
    }
}
