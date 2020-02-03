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
package com.luismalamoc.mainlogin.service;

import com.luismalamoc.mainlogin.MainLoginApplication;
import com.luismalamoc.mainlogin.entity.UserEntity;
import com.luismalamoc.mainlogin.exception.ModelValidationException;
import com.luismalamoc.mainlogin.mock.UserEntityMock;
import com.luismalamoc.mainlogin.mock.UserModelMock;
import com.luismalamoc.mainlogin.repository.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = { MainLoginApplication.class})
class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
    TokenService tokenService;

    @MockBean
    UserRepository repository;

    @Before
    void setUp() {
        when(tokenService.generateToken(UserModelMock.getUserModel())).thenReturn("");
        when(repository.save(any())).thenReturn(UserEntityMock.getUserEntity());
    }

    @Test
    void create() throws ModelValidationException {
        UserEntity test = userService.create(UserModelMock.getUserModel());
        assertNull(test);// TODO
    }
}