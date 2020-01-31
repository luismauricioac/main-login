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
package com.luismalamoc.mainlogin.exception;

/**
 * Duplicated User Exception
 *
 * @version 1.0.0
 * @author Luis Mauricio Alamo - luismalamoc@gmail.com
 * @since 1.0.0
 */
public class DuplicatedUserException extends Exception {

    public DuplicatedUserException() {
        super();
    }
    public DuplicatedUserException(String message, Throwable cause) {
        super(message, cause);
    }
    public DuplicatedUserException(String message) {
        super(message);
    }
    public DuplicatedUserException(Throwable cause) {
        super(cause);
    }
}
