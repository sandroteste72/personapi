package com.arpitech.personapi.service;

import com.arpitech.personapi.dto.request.PersonDTO;
import com.arpitech.personapi.dto.response.MessageResponseDTO;
import com.arpitech.personapi.entity.Person;
import com.arpitech.personapi.mapper.PersonMapper;
import com.arpitech.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDTO
                .builder()
                .message("Created person with ID: " + savedPerson.getId())
                .build();
    }
}
