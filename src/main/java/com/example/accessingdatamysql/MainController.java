package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class MainController {
  
  @Autowired
  private UserRepository userRepository;

  @RequestMapping(value = "/")
  public String index() {
    return "index";
  }

  @PostMapping(path="/add")
  public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
    User u = new User(name, email);
    userRepository.save(u);
    return "Saved";
  }

  @GetMapping(path="/all") 
  public @ResponseBody Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
}
