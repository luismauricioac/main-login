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
package com.luismalamoc.mainlogin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.luismalamoc.mainlogin.entity.UserEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

/**
 * Represents Phones Model Request
 *
 * @version 1.0.0
 * @author Luis Mauricio Alamo - luismalamoc@gmail.com
 * @since 1.0.0
 */
@Data
public class PhoneModel implements Serializable {

    private UUID id;

    @NotNull(message = "{phone.number.empty}")
    @Size(min = 3, max = 50, message = "{phone.number.size}")
    private String number;

    @JsonProperty("city_code")
    private String cityCode;

    @NotNull(message = "{phone.contry_code.empty}")
    @Size(min = 1, max = 50, message = "{phone.number.size}")
    @JsonProperty("contry_code")
    private String contryCode;
}
