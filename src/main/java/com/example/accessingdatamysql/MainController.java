package com.example.accessingdatamysql;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opencsv.exceptions.CsvException;

@Controller
@RequestMapping(path="/demo")
public class MainController {
  
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private MajorRequirementRepository majorRequirementRepository;

  @RequestMapping(value = "/")
  public String index() {
    return "index";
  }

  @PostMapping(path = "/add/majreq")
  public @ResponseBody String addMajReqs() {
    CsvReader reader = new CsvReader();
    List<String[]> reqs;
    try {
      reqs = reader.readFile(".\\data\\Requirements.csv");
      reqs.forEach(r -> {
        
          System.out.println(r[0] + ", " + r[1] + ", " + r[2] + ", " + r[3]);
          this.majorRequirementRepository.save(new MajorRequirements(Integer.parseInt(r[0]),r[1],r[2],r[3]));
        
      });
    } catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			e.printStackTrace();
		}
    
    return "Added Database";



  }

  @PostMapping(path="/add")
  public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
    User u = new User(name, email);
    userRepository.save(u);
    return "Saved";
  }

  @GetMapping(path="/all/user") 
  public @ResponseBody Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping(path="/all/majreq") 
  public @ResponseBody Iterable<MajorRequirements> getAllMajReqs() {
    return majorRequirementRepository.findAll();
  }
}
