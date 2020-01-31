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
package com.luismalamoc.mainlogin.handler;

import com.luismalamoc.mainlogin.exception.DuplicatedUserException;
import com.luismalamoc.mainlogin.model.ErrorModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * User Entity Exceptions Handler
 *
 * @version 1.0.0
 * @author Luis Mauricio Alamo - luismalamoc@gmail.com
 * @since 1.0.0
 */
@ControllerAdvice
class UserEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Value("${app.messages.duplicatedUser}")
    String duplicatedUserMessage;

    @ExceptionHandler({ DuplicatedUserException.class })
    public ResponseEntity<Object> handleDuplicatedUserException(
            Exception e, WebRequest request) {
        return new ResponseEntity<Object>(
                ErrorModel.builder().message(duplicatedUserMessage).build(), new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
