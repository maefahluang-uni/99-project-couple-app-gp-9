package th.mfu;




import java.util.List;
import java.util.Optional;

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
    private UserRepository userRepo;
     
    
    @RequestMapping("/register")
    public String registerPage(Model model){
     
       User user = new User();
        model.addAttribute("user", user);
        return "register";
    }
   
  // Example logging in your userController
@PostMapping("/register")
public String saveregister(@ModelAttribute User user){
    userRepo.save(user);
    // Log the user details
    System.out.println("User registered: " + user);
    return "redirect:/login";
}

    
    

    @GetMapping("/users")
    public String listUser(Model model){
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "list-user";
    }

    @PostMapping("/users")
    public String saveUsersString(@ModelAttribute User newUser) {
        // Save the user to the database
        userRepo.save(newUser);
        // Redirect to the user list page
        return "redirect:/users";
    }

    
    
    @GetMapping("/login")
    public String loginPage(Model model)
    {
        User user = new User();
        model.addAttribute("user",user);
        return "login";
    }

    @PostMapping("/login")
    public String showLogin(@ModelAttribute User loginUser, Model model) {
        // Assuming your UserRepository has a method to find a user by email
        Optional<User> optionalUser = userRepo.findByEmail(loginUser.getEmail());
    
        if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(loginUser.getPassword())) {
            // Authentication successful, redirect to the discover page
            return "redirect:/discover";
        } else {
            // Authentication failed, add an error message and return to the login page
            model.addAttribute("error", "Invalid email or password");
            return "redirect:/login";
        }
    }

    @GetMapping("/discover")
    public String showDiscoverPage() {
        return "discover";
    }

    
}

