package mk.ukim.finki.dians.ehotels.repository;

import mk.ukim.finki.dians.ehotels.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public Optional<User> findByUsername(String username);
    public Optional<User> findByUsernameAndPassword(String username,String password);


}
