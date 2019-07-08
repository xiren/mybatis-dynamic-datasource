package com.example.mybatisdynamicdatasource;

import com.example.mybatisdynamicdatasource.domain.Person;
import com.example.mybatisdynamicdatasource.domain.Phone;
import com.example.mybatisdynamicdatasource.infrastructure.repo.mapper.PersonMapper;
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
            Person person = new Person()
                    .setEmail("demo@email.com")
                    .setName("demo")
                    .setSex(Byte.valueOf("1"))
                    .setPhone(new Phone()
                            .setBrand("iPhone")
                            .setSystem("iOS"));
            personMapper.save(person);
            System.out.println(person.getId());
            personMapper.list().forEach(p -> System.out.println(p));
        }
    }

}
