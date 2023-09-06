package com.igor.boot.fullstackApp.util;

import com.igor.boot.fullstackApp.entity.Person;
import com.igor.boot.fullstackApp.service.PersonDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PersonDetailsService personDetailsService;

    public PersonValidator(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        try {
            personDetailsService.loadUserByUsername(person.getUsername());

        } catch (UsernameNotFoundException ignored) {
            return;
        }

        errors.rejectValue("username", "username.exists", "Username already exists");

    }
}

