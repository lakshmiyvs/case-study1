package com.casestudy1.webapp.database.entity;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer userid;

    @Column(name = "name", length = 75, nullable = false)
    private String name;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "password", length = 75, nullable = false)
    private String password;

    @Column(name = "phone", length = 45)
    private String phone;

    @Column(name = "userroleid")
    private Integer userRoleid;

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", userRoleId=" + userRoleid +
                '}';
    }





}
