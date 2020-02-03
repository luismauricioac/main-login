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
package com.luismalamoc.mainlogin.mock;

import com.luismalamoc.mainlogin.model.PhoneModel;
import com.luismalamoc.mainlogin.model.UserModel;

import java.util.HashSet;
import java.util.Set;

public class UserModelMock {

    public static UserModel getUserModel(){
        Set<PhoneModel> phones = new HashSet<>();
        phones.add(
                PhoneModel.builder()
                        .number("555444666")
                        .cityCode("2")
                        .contryCode("56")
                        .build()
        );
        return UserModel.builder()
                .phones(phones)
                .firstName("Tony")
                .lastName("Stark")
                .email("tony.stark@starkindustries.com")
                .password("Mypasswd01")
                .build();

    }
}
