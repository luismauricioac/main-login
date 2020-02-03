/**
 * Copyright 2020 Luismalamoc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.luismalamoc.mainlogin.validator;

import com.luismalamoc.mainlogin.MainLoginApplication;
import com.luismalamoc.mainlogin.repository.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintValidatorContext;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = { MainLoginApplication.class})
class UniqueEmailValidatorTest {

    @MockBean
    ConstraintValidatorContext constraintValidatorContext;

    @MockBean
    UserRepository repository;

    UniqueEmailValidator uniqueEmailValidator = new UniqueEmailValidator();

    @Before
    void setUp(){
        when(repository.countByEmail("")).thenReturn(Long.valueOf(0));
    }

    //TODO
    /*@Test
    void isValid() {
        assertNotNull(uniqueEmailValidator.isValid("mail@mail.com", constraintValidatorContext));
    }*/
}