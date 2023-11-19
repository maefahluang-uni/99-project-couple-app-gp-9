package th.mfu;

import org.springframework.data.jpa.repository.JpaRepository;
import th.mfu.Domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    // You can add custom query methods here if needed
}

