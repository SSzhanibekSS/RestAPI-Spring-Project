package com.example.restapi.RestAPISpringProject.util;

import com.example.restapi.RestAPISpringProject.dto.PersonDTO;
import com.example.restapi.RestAPISpringProject.model.Person;
import com.example.restapi.RestAPISpringProject.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class RegisterValidator implements Validator {
    private final PersonRepository repository;
    @Autowired
    public RegisterValidator(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return PersonDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        PersonDTO person = (PersonDTO) o;

        Optional<Person> byUsername = repository.findByUsername(person.getUsername());

        if (byUsername.isPresent()){
            errors.rejectValue("username", "", "User with such an username already exists");
        }


        if (!person.getPassword().equals(person.getConfirmPassword())){
            errors.rejectValue("password", "", "Passwords don't match");
        }
        if (person.getPassword().length() < 8){
            errors.rejectValue("password", "", "Passwords should be more than 8 characters");

        }

    }
}
