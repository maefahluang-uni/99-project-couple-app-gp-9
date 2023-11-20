package th.mfu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.mfu.Domain.User;
import th.mfu.Domain.Like;
import th.mfu.Domain.Post;

import java.util.Optional;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public void likePost(Long postId) {
        Optional<User> currentUser = userRepository.findById(1L);
        Optional<Post> post = postRepository.findById(postId);

        if (currentUser.isPresent() && post.isPresent()) {
            Like like = new Like(currentUser.get(), post.get());
            likeRepository.save(like);
        }
    }

    public void unlikePost(Long postId) {
        Optional<User> currentUser = userRepository.findById(1L);
        Optional<Post> post = postRepository.findById(postId);

        if (currentUser.isPresent() && post.isPresent()) {
            Optional<Like> like = likeRepository.findByUserAndPost(currentUser.get(), post.get());
            like.ifPresent(likeRepository::delete); // Using ifPresent to avoid null checks
        }
    }
}
