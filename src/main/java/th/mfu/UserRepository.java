package th.mfu;

import org.springframework.data.jpa.repository.JpaRepository;
import th.mfu.Domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom query methods here if needed
}
