package com.example.restapi.RestAPISpringProject.services;

import com.example.restapi.RestAPISpringProject.dto.PersonDTO;
import com.example.restapi.RestAPISpringProject.model.Person;
import com.example.restapi.RestAPISpringProject.repositories.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository repository;
    private final ModelMapper mapper;
    private final PasswordEncoder encoder;

    @Autowired
    public PersonService(PersonRepository repository, ModelMapper mapper, PasswordEncoder encoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.encoder = encoder;
    }
    @Transactional
    public void saveNewPerson(PersonDTO personDTO){

        Person person = mapToPerosn(personDTO);
        String password = person.getPassword();

        String encodePassword = encoder.encode(password);

        person.setPassword(encodePassword);

        repository.save(person);

    }
    private Person mapToPerosn(PersonDTO personDTO){
        return mapper.map(personDTO, Person.class);
    }


}
