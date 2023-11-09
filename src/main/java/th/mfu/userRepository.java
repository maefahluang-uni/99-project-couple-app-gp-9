package th.mfu;

import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<User, Long>{

    
}
