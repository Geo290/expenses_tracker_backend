package com.xitcode.expenseTracker.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(nullable = false, length = 40)
    private String name;

    @Column(nullable = false, length = 40)
    private String lastName;

    @Column(name = "username", nullable = false, length = 20, unique = true)
    private String userName;

    @Column(nullable = false, length = 60, unique = true)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

}
