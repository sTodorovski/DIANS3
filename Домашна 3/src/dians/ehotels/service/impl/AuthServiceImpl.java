package mk.ukim.finki.dians.ehotels.service.impl;
import mk.ukim.finki.dians.ehotels.model.User;
import mk.ukim.finki.dians.ehotels.model.exceptions.*;

import mk.ukim.finki.dians.ehotels.repository.UserRepository;
import mk.ukim.finki.dians.ehotels.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service za Avtentikacijata.
 */

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    /**
     * Constructor so argumenti za AuthServiceImpl.
     * @param userRepository - interfejs za pronaogjanje na eden korisnik.
     * @param passwordEncoder - promenliva koja ja enkriptira lozinkata pred da se zacuva vo bazata.
     */
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * So ovoj metod se vrsi registracija na nov korisnik,
     * Potrebni se 5 informacii od korisnikot. Vnesenite informacii se proveruvaat dali se postecki i validni,
     * Vnesenite informacii dokolku se validni se zacuvuvaat vo userRepository.
     * @param username - pole kade se cuva privremeno korisnickoto ime na korisnikot.
     * @param password - pole kade se cuva privremeno passwordot na korisnikot.
     * @param repeatedPassword - pole za potvrda na passwordot.
     * @param name - pole kade se cuva privremeno imeto na korisnikot.
     * @param surname - pole kade se cuva privremeno prezimeto na korisnikot.
     * @return da zacuvuva nov korisnik vo bazata.
     */
    @Override
    public User register(String username, String password, String repeatedPassword, String name, String surname) {


        if(username==null || username.isEmpty()|| password==null || password.isEmpty() || repeatedPassword==null || repeatedPassword.isEmpty() || name==null || name.isEmpty() || surname==null || surname.isEmpty())
            throw new InvalidArgumentsException();

        if(!password.equals(repeatedPassword)){
            throw new PasswordsNotMatchException();
        }

        if(userRepository.findByUsername(username).isPresent()){
            throw new UserAlreadyExistsException(username);
        }

        return userRepository.save(new User(username,passwordEncoder.encode(password),name,surname));
    }

    /**
     * So ovoj metod se vrsi najava na vekje postecki korisnik,
     * Potrebni se 2 informacii od korisnikot, koi se proveruvaat dali se postecki i validni.
     * @param username - pole kade se cuva privremeno korisnickoto ime na korisnikot.
     * @param password - pole kade se cuva privremeno passwordot na korisnikot.
     * @return go vrakja korisnikot.
     */
    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password.isEmpty() || password == null)
            throw new InvalidUserCredentialsException();

        User user = userRepository.findByUsername(username).orElseThrow(UserNotExistsException::new);

        if(!user.getPassword().equals(password))
            throw new InvalidUserCredentialsException();

        return user;
    }



}
