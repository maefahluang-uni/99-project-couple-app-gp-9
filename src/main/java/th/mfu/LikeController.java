package th.mfu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping("/like/{postId}")
    public String likePost(@PathVariable Long postId) {
        likeService.likePost(postId);
        return "redirect:/"; // Redirect to the home page or another appropriate page
    }

    @PostMapping("/unlike/{postId}")
    public String unlikePost(@PathVariable Long postId) {
        likeService.unlikePost(postId);
        return "redirect:/"; // Redirect to the home page or another appropriate page
    }
}
