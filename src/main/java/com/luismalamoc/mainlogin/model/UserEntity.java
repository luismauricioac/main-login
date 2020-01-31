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
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

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
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long userId;

    @Column(name="first_name")
    @NotEmpty
    @JsonProperty("first_name")
    private String firstName;

    @Column(name="last_name")
    @NotEmpty
    @JsonProperty("last_name")
    private String lastName;

    @Column(name="email", unique = true)
    @NotEmpty
    @Email(message = "${validation.unique.email}")
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

    @Column(name="uuid")
    @JsonProperty("id")
    private String uuid;
}
