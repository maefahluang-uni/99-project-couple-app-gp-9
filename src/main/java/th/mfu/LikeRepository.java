package th.mfu;

import th.mfu.Domain.Like;
import th.mfu.Domain.User;  // Correct import for User class
import th.mfu.Domain.Post;  // Correct import for Post class

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserAndPost(User user, Post post);
}
