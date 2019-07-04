package com.example.mybatisdynamicdatasource;

import com.example.mybatisdynamicdatasource.entity.Person;
import com.example.mybatisdynamicdatasource.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MybatisDynamicDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisDynamicDatasourceApplication.class, args);
    }

    @Component
    public static class Command implements CommandLineRunner {

        private PersonMapper personMapper;

        @Autowired
        public Command(PersonMapper personMapper) {
            this.personMapper = personMapper;
        }

        @Override
        public void run(String... args) throws Exception {
            Person person = new Person();
            person.setEmail("demo@email.com");
            person.setName("demo");
            person.setSex(Byte.valueOf("1"));
            personMapper.save(person);
            personMapper.list().forEach(p -> System.out.println(p));
        }
    }

}
