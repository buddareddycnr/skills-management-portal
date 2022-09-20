package co.uk.skills.dao;

import co.uk.skills.entity.Login;

public interface LoginDao {
    Login authenticateUser(String userName, String password);
}
