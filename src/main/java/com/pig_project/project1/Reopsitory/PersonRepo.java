package com.pig_project.project1.Reopsitory;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pig_project.project1.Model.Person;

public interface PersonRepo extends MongoRepository<Person, String>{
     
	@Query("{'fullName' : ?0}")
	Person findBy(String fullName);


	

}
