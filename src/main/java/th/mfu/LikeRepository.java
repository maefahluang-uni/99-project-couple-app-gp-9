package th.mfu;

import org.springframework.data.jpa.repository.JpaRepository;
import th.mfu.Domain.Like;
import th.mfu.Domain.User;
import th.mfu.Domain.Post;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserAndPost(User user, Post post);
}
