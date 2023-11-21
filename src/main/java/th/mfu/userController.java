package th.mfu;




import java.util.List;

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
    

        
    //     if (user.getEmail() == null || user.getEmail().isEmpty() ||
    //     user.getPassword() == null || user.getPassword().isEmpty()) {
    //     model.addAttribute("error", "Please fill in all the fields.");
    //     return "register"; // Display the registration form with an error message
    // }

    // // Simulated check for existing email
    // for (User existingUser : users) {
    //     if (existingUser.getEmail().equals(user.getEmail())) {
    //         model.addAttribute("error", "Email already registered.");
    //         return "register"; // Display the registration form with an error message
    //     }

    // }
    }

    // // Registration successful
   

    

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
    public String showLogin(@ModelAttribute User newUser) {
        // Save the user to the database
        userRepo.save(newUser);
        // Redirect to the user list page
        return "redirect:/login";
    }
}
