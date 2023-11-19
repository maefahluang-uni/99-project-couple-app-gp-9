package th.mfu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import th.mfu.Domain.User;

@Controller
public class userController {


    @Autowired
    private userRepository userRepo;

    @RequestMapping("/register")
    public String registerPage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "register";

    }

    @GetMapping("/users")
    public String listUser(Model model){
        model.addAttribute("users", userRepo.findAll());
        return "list-user";
    }

    @PostMapping("/users")
    public String saveUsersString(@ModelAttribute User newUser) {
        // Save the user to the database
        userRepo.save(newUser);
        // Redirect to the user list page
        return "redirect:/users";
    }
    
    
    // @GetMapping("/login")
    // public String loginPage(Model model)
    // {
    //     User user = new User();
    //     model.addAttribute("user",user);
    //     return "login";
    // }

    
}
