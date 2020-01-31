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

import com.luismalamoc.mainlogin.exception.DuplicatedUserException;
import com.luismalamoc.mainlogin.model.UserEntity;
import com.luismalamoc.mainlogin.repository.UserRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.UUID;

/**
 * Service for Users Table
 *
 * @version 1.0.0
 * @author Luis Mauricio Alamo - luismalamoc@gmail.com
 * @since 1.0.0
 */
@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    TokenService tokenService;

    public UserEntity create(UserEntity entity) throws DuplicatedUserException {
        UserEntity newEntity = null;
        entity.setToken(tokenService.generateToken(entity));
        entity.setUuid(UUID.randomUUID().toString());
        entity.setPassword(this.encryptPasswd(entity.getPassword()));
        newEntity = repository.save(entity);
        return newEntity;
    }

    private String encryptPasswd(String userPwd){
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        return passwordEncryptor.encryptPassword(userPwd);
    }

}
