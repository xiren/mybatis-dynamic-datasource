package com.example.mybatisdynamicdatasource.api;

import com.example.mybatisdynamicdatasource.application.PersonService;
import com.example.mybatisdynamicdatasource.application.param.PersonCreateParam;
import com.example.mybatisdynamicdatasource.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/person")
public class PersonRestApi {

    private PersonService personService;

    @Autowired
    public PersonRestApi(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    public long create(@RequestBody @Valid PersonCreateParam personCreateParam) {
        return personService.save(personCreateParam);
    }

    @GetMapping("/list")
    public List<Person> list() {
        return personService.list();
    }
}
