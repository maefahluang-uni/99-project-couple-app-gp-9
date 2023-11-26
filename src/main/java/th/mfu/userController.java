package th.mfu;




import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    // @Autowired
    // private UserService userService;
     
    
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
        // List<User> users = userRepo.findAll();
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

    // @GetMapping("/discover")
    // public String showDiscoverPage(Model model) {
    //     List<User> users = userRepo.findAll();
    //     List<User> randomizedUsers = new ArrayList<>(users);
        
    //     // Randomize the order of the list
    //     Collections.shuffle(randomizedUsers);
    //     model.addAttribute("users", randomizedUsers);
    //     return "discover";
    // }


    @GetMapping("/discover")
    public String showFirstDiscoverPage(Model model) {
        List<User> users = userRepo.findAll();
        List<User> randomizedUsers = new ArrayList<>(users);
        Collections.shuffle(randomizedUsers);

        model.addAttribute("users", randomizedUsers.get(0));
        model.addAttribute("currentIndex", 0);

        return "discover";
    }

    // Method to show the next randomized user
    @GetMapping("/discover/{currentIndex}/like")
    public String showNextDiscoverPage(@PathVariable int currentIndex, Model model) {
        List<User> users = userRepo.findAll();
        List<User> randomizedUsers = new ArrayList<>(users);
        Collections.shuffle(randomizedUsers);

        int totalUsers = randomizedUsers.size();
        int nextIndex = (currentIndex + 1) % totalUsers;

        model.addAttribute("users", randomizedUsers.get(nextIndex));
        model.addAttribute("currentIndex", nextIndex);

        return "discover";
    }































    @GetMapping("/delete-user/{ID}")
    public String deleteUsers(@PathVariable("ID") long ID) {
    userRepo.deleteById(ID);
    return "redirect:/users";
}


// @GetMapping("/like-user/{ID}")
// public String likeUser(@PathVariable Long ID) {
//     userRepo.likeUser(ID);
//     return "redirect:/users"; // Redirect to the users page after liking
// }

// @GetMapping("/unlike-user/{ID}")
// public String unlikeUser(@PathVariable Long ID) {
//     userRepo.unlikeUser(ID);
//     return "redirect:/users"; // Redirect to the users page after unliking
// }

    
}

