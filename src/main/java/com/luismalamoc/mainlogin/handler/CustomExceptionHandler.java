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

import com.luismalamoc.mainlogin.exception.ModelValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;

/**
 * Custom Global Exceptions Handler
 *
 * @version 1.0.0
 * @author Luis Mauricio Alamo - luismalamoc@gmail.com
 * @since 1.0.0
 */
@ControllerAdvice
class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(ModelValidationException.class)
    public void handlePasswordException(HttpServletResponse response, Exception e) throws IOException {
        logger.info("A validation problem has happened: ".concat(e.getMessage()));
        response.sendError(HttpStatus.UNPROCESSABLE_ENTITY.value());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public void handleViolationException(HttpServletResponse response, Exception e) throws IOException {
        logger.info("A Database Integrity Violation has happened: ".concat(e.getMessage()));
        response.sendError(HttpStatus.UNPROCESSABLE_ENTITY.value());
    }
}
