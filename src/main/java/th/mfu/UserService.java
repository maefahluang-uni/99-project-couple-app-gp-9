package th.mfu;

import org.springframework.security.core.userdetails.UserDetailsService;

import th.mfu.Domain.User;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDetail registrationDetail);
}
