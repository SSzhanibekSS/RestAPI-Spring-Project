package com.example.restapi.RestAPISpringProject.services;

import com.example.restapi.RestAPISpringProject.model.Person;
import com.example.restapi.RestAPISpringProject.repositories.PersonRepository;
import com.example.restapi.RestAPISpringProject.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PersonRepository repository;
    @Autowired
    public PersonDetailsService(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Person> byUsername = repository.findByUsername(s);

        if (byUsername.isEmpty()){
            throw new UsernameNotFoundException("User with this username not found");
        }


        return new PersonDetails(byUsername.get());
    }
}
