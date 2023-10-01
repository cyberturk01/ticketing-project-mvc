package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class User extends BaseEntity{
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private boolean enabled;
    private Gender gender;
    private Role role;

    public User(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserId, String firstName, String lastName, String email, String phone, String password, boolean enabled, Gender gender, Role role) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.enabled = enabled;
        this.gender = gender;
        this.role = role;
    }
}
