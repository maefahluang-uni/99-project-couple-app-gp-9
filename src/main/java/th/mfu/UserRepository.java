package th.mfu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import th.mfu.Domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> profileusers = new ArrayList<>();
    // You can add custom query methods here if needed
    Optional<User> findByEmail(String email);
    void deleteById(Long ID);
   
    Optional<User> findById(Long ID);

}
