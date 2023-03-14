package com.pig_project.project1.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.pig_project.project1.Exception.ResourceNotFoundException;
import com.pig_project.project1.Model.Person;
import com.pig_project.project1.Reopsitory.PersonRepo;

@Service
public class PersonService {
	  
	  @Autowired
	  PersonRepo person_operation;
	
	  public Person Return_person(String id) throws ResourceNotFoundException {
		  
    	  Optional<Person> p= person_operation.findById(id);
    	  
    	  if(p.isPresent()) {
    		  return p.get();
    	  }
    	  else
    		  throw new ResourceNotFoundException(" Person not found "); 
    	  
    	 
    	  
      }

	public Person add(Person p) {
		return person_operation.insert(p);
	}

	public List<Person> get_all_person() {
		// TODO Auto-generated method stub
		return person_operation.findAll();
	}

	public List<String> get_person_emails(String id) {
		// TODO Auto-generated method stub
		    Optional<Person> p=person_operation.findById(id);
		    if(p.isPresent())
		    {
		    	return p.get().getEmail();
		    }else
		    	
		    	 throw new ResourceNotFoundException(" Person not found ");
	    }

	public String edit_person_Info(String id,Person p) {
		// TODO Auto-generated method stub
		 Optional<Person> person_is_present=person_operation.findById(id);
		 if(person_is_present.isPresent())
		    {
			 person_operation.save(p);
			 return "Info Updated";
		    }
		 else 
			 return "person not found";
	}

	public String delete_person(String id) {
		 Optional<Person> person=person_operation.findById(id);
		 if(person.isPresent()) {
			 person_operation.deleteById(id);
			 return "Successfully deleted";
			 
		 }else
			 return "person not found";
	}
	

	public Person update_person_email(String id, List<String> newEmails) {
		 Optional<Person> person=person_operation.findById(id);
		 if(person.isPresent()) {
			person.get().setEmail(newEmails);
			person_operation.save(person.get());
			
			return person.get();
		 }
		 else 
			 throw new ResourceNotFoundException(" Person not found ");
	}
	
	

	public Person edit_specefic_email(String fullName, String new_email ,int num_of_email) {
		
		Person person=person_operation.findBy(fullName);
		person.getEmail().set(num_of_email, new_email);
		 return person;
		 
		
	}
	
	  
	
	
	
	
	
	
}
