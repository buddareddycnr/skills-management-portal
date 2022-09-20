package co.uk.skills.service.impl;

import co.uk.skills.dao.LoginDao;
import co.uk.skills.entity.Login;
import co.uk.skills.exception.LoginFailedException;
import co.uk.skills.exception.MandatoryFieldMissingException;
import co.uk.skills.service.LoginService;
import co.uk.skills.util.MandatoryFieldsLengthValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    private LoginDao loginDao;
    private MandatoryFieldsLengthValidator<Login> mandatoryFieldsLengthValidator;

    @Autowired
    public LoginServiceImpl(LoginDao loginDao,MandatoryFieldsLengthValidator mandatoryFieldsLengthValidator) {
        this.loginDao = loginDao;
        this.mandatoryFieldsLengthValidator = mandatoryFieldsLengthValidator;
    }

    /**
     * @param userName
     * @param password
     * @return
     */
    @Override
    public Boolean login(String userName, String password) {
        if(mandatoryFieldsLengthValidator.isValidStringLength(userName)
                && mandatoryFieldsLengthValidator.isValidStringLength(password)){
            if(null != loginDao.authenticateUser(userName, password))
                return true;
            else
                return false;
            }else {
            throw new MandatoryFieldMissingException("Username, password fields should be valid");
        }

    }

    /**
     * @param token
     * @return
     */
    @Override
    public Optional<Boolean> logout(String token) {

        return Optional.empty();
    }
}
