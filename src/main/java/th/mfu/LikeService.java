package th.mfu;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.mfu.Domain.Like;
import th.mfu.Domain.User;  // Import the correct User class
import th.mfu.Domain.Post;  // Import the correct Post class

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private userRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    public void likePost(Long postId) {
        Optional<User> currentUser = userRepository.findById(1L); // Assuming userRepository is properly defined
        Optional<Post> post = postRepository.findById(postId);

        if (currentUser.isPresent() && post.isPresent()) {
            Like like = new Like(currentUser.get(), post.get());
            likeRepository.save(like);
        }
    }

    public void unlikePost(Long postId) {
        Optional<User> currentUser = userRepository.findById(1L); // Assuming userRepository is properly defined
        Optional<Post> post = postRepository.findById(postId);

        if (currentUser.isPresent() && post.isPresent()) {
            Optional<Like> like = likeRepository.findByUserAndPost(currentUser.get(), post.get());
            if (like.isPresent()) {
                likeRepository.delete(like.get());
            }
        }
    }
}
