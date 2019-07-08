package com.example.mybatisdynamicdatasource.infrastructure.repo;

import com.example.mybatisdynamicdatasource.domain.Person;
import com.example.mybatisdynamicdatasource.infrastructure.repo.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepo {

    private PersonMapper personMapper;

    @Autowired
    public PersonRepo(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    public void save(Person person) {
        personMapper.save(person);
    }

    public List<Person> list() {
        return personMapper.list();
    }
}
