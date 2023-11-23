package th.mfu;


import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import th.mfu.Domain.User;

@Controller

public class userController {


  
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService userService;
     
    
    @RequestMapping("/register")
    public String registerPage(Model model){
       User user = new User();
        model.addAttribute("user", user);
        return "register";
    
    }

    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute UserRegistrationDetail userRegistrationDetail){
        userService.save(userRegistrationDetail);
        return "redirect:/register?success";
    }
        
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



    // @PostMapping("/like/{userId}")
    // public String likeUser(@PathVariable Long userId) {
    //     // Get the current user's ID (you may need to adjust this based on your authentication mechanism)
    //     Long currentUserId = getCurrentUserId();

    //     // Check if the other user has already liked the current user
    //     if (likeRepo.existsByUserId2AndUserId1(userId, currentUserId)) {
    //         // Matched! Show the matched page
    //         return "redirect:/matched";
    //     } else {
    //         // Record the like
    //         likeRepo.save(new Like(currentUserId, userId));
    //         // Redirect back to the list of users
    //         return "redirect:/users";
    //     }
    // }

    // private Long getCurrentUserId() {
    //     return null;
    // }

    // private Long getCurrentUserId() {
    //     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
    //     // Check if the user is authenticated
    //     if (authentication != null && authentication.isAuthenticated()) {
    //         // Retrieve the principal (which should be your User object)
    //         Object principal = authentication.getPrincipal();
    
    //         // Assuming your User object has a method to get the user ID
    //         if (principal instanceof User) {
    //             return ((User) principal).getID(); // Replace with your actual method to get ID
    //         }
    //     }
    
    //     // If not authenticated or no user details available, return null or handle accordingly
    //     return null;
    // }
}
