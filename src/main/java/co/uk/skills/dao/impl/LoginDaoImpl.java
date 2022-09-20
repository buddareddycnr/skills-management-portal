package co.uk.skills.dao.impl;

import co.uk.skills.dao.LoginDao;
import co.uk.skills.entity.Login;
import co.uk.skills.exception.CustomerNotFoundException;
import co.uk.skills.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginDaoImpl implements LoginDao {
    private LoginRepository loginRepository;

    @Autowired
    public LoginDaoImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    /**
     * @param userName
     * @param password
     * @return
     */
    @Override
    public Login authenticateUser(String userName, String password) {
        return loginRepository.findByUsernameAndPassword(userName,password).orElseThrow(()->
                new CustomerNotFoundException("Login failed due to user credentials does not match with database record"));
    }
}
