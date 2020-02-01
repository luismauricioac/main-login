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
package com.luismalamoc.mainlogin.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

/**
 * Represents Users Table on the Database
 *
 * @version 1.0.0
 * @author Luis Mauricio Alamo - luismalamoc@gmail.com
 * @since 1.0.0
 */
@Entity
@Table(name = "T_USERS")
@Data
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name="first_name")
    @NotNull(message = "user.first_name.empty")
    @Size(min = 3, max = 50, message = "user.first_name.size")
    @JsonProperty("first_name")
    private String firstName;

    @Column(name="last_name")
    @NotNull(message = "user.last_name.empty")
    @Size(min = 3, max = 50, message = "user.last_name.size")
    @JsonProperty("last_name")
    private String lastName;

    @Column(name="email", unique = true)
    @NotNull(message = "user.email.empty")
    @Email(message = "user.email.mask")
    private String email;

    @Column(name="password")
    @NotEmpty
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<PhoneEntity> phones;

    @Column(name="created")
    @CreationTimestamp
    private LocalDateTime created;

    @Column(name="modified")
    @UpdateTimestamp
    private LocalDateTime modified;

    @Column(name="last_login")
    private LocalDateTime lastLogin;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="token")
    private String token;
}
