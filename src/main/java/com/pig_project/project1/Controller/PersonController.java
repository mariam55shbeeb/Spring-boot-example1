package com.pig_project.project1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pig_project.project1.Model.Person;
import com.pig_project.project1.Service.PersonService;

import jakarta.websocket.server.PathParam;

@RestController
public class PersonController {
	
	@Autowired
	PersonService ps;
	
	@GetMapping("/k")
	String hello() {
		return "hello";
	}
	
    @GetMapping("/Get/{id}")
    Person Get_PersonzById(@PathVariable String id ) {
    	return ps.Return_person(id);
    }
    
    @PostMapping("/Add")
    String RigesterNewPerson(@RequestBody Person p)
    {
    	return ps.add(p);
    }
    
    @GetMapping("/GetAll")
    List<Person> SeeAllPerson(){
    	return ps.get_all_person();
    }
    
    @GetMapping("/GetAllEmails/{id}")
    List<String> AllEmailes(@PathVariable String id ){
    	return ps.get_person_emails(id);
    }
    
    @PutMapping("/Edit/{id}")
    String EditProfile(@PathVariable String id,@RequestBody Person p) {
    	return ps.edit_person_Info(id,p);
    }
    
    @DeleteMapping("/Del/{id}")
    String DeletePerson(@PathVariable String id) {
    	return ps.delete_person(id);
    }
    
    @PutMapping("/EditEmails/{id}")
    Person EditEmail(@PathVariable String id,@RequestBody List<String> newEmails) {
    	return ps.update_person_email(id,newEmails);
    }
    
    
    @PutMapping("/EditSpecificEmail/{fullName}/{num_of_email}")
    Person EditSpeceficEmail(@PathVariable String fullName,@PathVariable int num_of_email,@RequestBody String email) {
    	
    	return ps.edit_specefic_email(fullName,email,num_of_email);
    }
    
    
    
}
