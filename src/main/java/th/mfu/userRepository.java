package th.mfu;

import th.mfu.Domain.User;  // Import the correct User class
import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<User, Long> {
    // ... your repository methods
}

