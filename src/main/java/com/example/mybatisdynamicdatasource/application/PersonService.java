package com.example.mybatisdynamicdatasource.application;

import com.example.mybatisdynamicdatasource.application.param.PersonCreateParam;
import com.example.mybatisdynamicdatasource.domain.Person;
import com.example.mybatisdynamicdatasource.infrastructure.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public long save(PersonCreateParam param) {
        Person person = new Person()
                .setEmail(param.getEmail())
                .setName(param.getName())
                .setSex(param.getSex())
                .setPhone(param.getPhone());
        personRepo.save(person);
        return person.getId();
    }

    public List<Person> list() {
        return personRepo.list();
    }
}
