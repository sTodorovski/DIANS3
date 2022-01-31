package mk.ukim.finki.dians.ehotels.service;


import mk.ukim.finki.dians.ehotels.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String name, String surname);



}
