package th.mfu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import th.mfu.Domain.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public User save(UserRegistrationDetail registrationDetail) {
        User user = new User(registrationDetail.getFirstName(),
        registrationDetail.getLastName(),registrationDetail.getEmail(),registrationDetail.getPassword(),
        registrationDetail.getCountry(),registrationDetail.getDateOfBirth(),registrationDetail.getGender(),
        registrationDetail.getID_card(),registrationDetail.getInterest(),
        registrationDetail.getTelephone());
        return userRepository.save(user);
    
}



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
    }
}
