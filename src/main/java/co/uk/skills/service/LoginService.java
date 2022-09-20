package co.uk.skills.service;

import java.util.Optional;

public interface LoginService {
    Boolean login(String userName, String password);
    Optional<Boolean> logout(String token);
}
