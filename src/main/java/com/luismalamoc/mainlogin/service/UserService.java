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

import com.luismalamoc.mainlogin.entity.PhoneEntity;
import com.luismalamoc.mainlogin.entity.UserEntity;
import com.luismalamoc.mainlogin.exception.ModelValidationException;
import com.luismalamoc.mainlogin.model.PhoneModel;
import com.luismalamoc.mainlogin.model.UserModel;
import com.luismalamoc.mainlogin.repository.UserRepository;
import com.luismalamoc.mainlogin.helper.EncryptHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.HashSet;
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

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository repository;

    @Autowired
    TokenService tokenService;

    @Autowired
    Validator validator;

    public UserEntity create(UserModel model) throws ModelValidationException {
        this.doValidations(model);
        this.fillPhones(model);
        logger.info("All validations passed");
        UserEntity ret = repository.save(
                UserEntity.builder()
                        .phones(this.fillPhones(model))
                        .firstName(model.getFirstName())
                        .lastName(model.getLastName())
                        .email(model.getEmail())
                        .password(EncryptHelper.encryptPasswd(model.getPassword()))
                        .isActive(true)
                        .lastLogin(LocalDateTime.now())
                        .token(tokenService.generateToken(model))
                        .build()
        );
        logger.info("New user was stored");
        return ret;
    }

    private void doValidations(UserModel model) throws ModelValidationException {
        Set<ConstraintViolation<UserModel>> result = validator.validate(model);
        if (!result.isEmpty()) {
            throw new ModelValidationException(result.iterator().next().getMessage());
        }
        for (PhoneModel phone : model.getPhones())
        {
            this.doPhoneValidations(phone);
        }
    }

    private void doPhoneValidations(PhoneModel model) throws ModelValidationException {
        Set<ConstraintViolation<PhoneModel>> result = validator.validate(model);
        if (!result.isEmpty()) {
            throw new ModelValidationException(result.iterator().next().getMessage());
        }
    }

    private Set<PhoneEntity> fillPhones(UserModel model){
        Set<PhoneEntity> phones = new HashSet<>();
        for (PhoneModel phone : model.getPhones())
        {
            phones.add(
                    PhoneEntity.builder()
                            .number(phone.getNumber())
                            .cityCode(phone.getCityCode())
                            .contryCode(phone.getContryCode())
                            .build()
            );
        }
        return phones;
    }

}
