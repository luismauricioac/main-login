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

import lombok.Data;

import javax.persistence.*;

import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Set;

/**
 * Represents Users Table on the Database
 *
 * @version 1.0.0
 * @author Luis Mauricio Alamo - luismalamoc@gmail.com
 * @since 1.0.0
 */
@Entity
@Table(appliesTo = "T_USERS")
@Data
public class UserEntity implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email", unique = true)
    private String email;

    @Column(name="password")
    private String password;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<PhoneEntity> phones;

    @Column(name="created")
    private String created;

    @Column(name="modified")
    private String modified;

    @Column(name="last_login")
    private String lastLogin;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="token")
    private String token;
}
