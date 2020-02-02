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
package com.luismalamoc.mainlogin.controller;

import com.luismalamoc.mainlogin.entity.UserEntity;
import com.luismalamoc.mainlogin.exception.ModelValidationException;
import com.luismalamoc.mainlogin.model.UserModel;
import com.luismalamoc.mainlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for Users
 *
 * @version 1.0.0
 * @author Luis Mauricio Alamo - luismalamoc@gmail.com
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserEntity> create(@RequestBody UserModel user) throws ModelValidationException {
        UserEntity created = service.create(user);
        return new ResponseEntity<UserEntity>(created, new HttpHeaders(), HttpStatus.OK);
    }

}
