package mk.ukim.finki.dians.ehotels.service;

import mk.ukim.finki.dians.ehotels.model.ShoppingCart;
import mk.ukim.finki.dians.ehotels.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService  {
    public User register(String username, String password, String repeatedPassword, String name, String surname);
    public User login(String username,String password);
    public ShoppingCart findShoppingCart(User user);
}
