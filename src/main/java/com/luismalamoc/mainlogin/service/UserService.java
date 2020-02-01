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

import com.luismalamoc.mainlogin.entity.UserEntity;
import com.luismalamoc.mainlogin.exception.EntityValidationException;
import com.luismalamoc.mainlogin.model.UserCredentialsModel;
import com.luismalamoc.mainlogin.repository.UserRepository;
import com.luismalamoc.mainlogin.helper.EncryptHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.Set;

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

    @Autowired
    Validator validator;

    public UserEntity create(UserEntity entity) throws EntityValidationException {
        this.doValidationPassword(entity);
        this.doValidationEverythingElse(entity);
        UserEntity newEntity = null;
        entity.setToken(tokenService.generateToken(entity));
        entity.setPassword(EncryptHelper.encryptPasswd(entity.getPassword()));
        entity.setLastLogin(LocalDateTime.now());
        entity.setActive(true);
        newEntity = repository.save(entity);
        return newEntity;
    }

    private void doValidationPassword(UserEntity entity) throws EntityValidationException {
        Set<ConstraintViolation<UserCredentialsModel>> result = validator.validate(UserCredentialsModel.builder()
                .password(entity.getPassword()).build());
        if (!result.isEmpty()) {
            throw new EntityValidationException(result.iterator().next().getMessage());
        }
    }

    private void doValidationEverythingElse(UserEntity entity) throws EntityValidationException {
        Set<ConstraintViolation<UserEntity>> result = validator.validate(entity);
        if (!result.isEmpty()) {
            throw new EntityValidationException(result.iterator().next().getMessage());
        }
    }

}
