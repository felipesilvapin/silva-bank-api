package com.studies.silvabankapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "accounts")
@Entity(name = "Account")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String birth;
    private String email;
    @Embedded
    private Address address;

    public Account(AccountRegistration data) {
        this.name = data.name();
        this.cpf = data.cpf();
        this.birth = data.birth();
        this.email = data.email();
        this.address = new Address(data.addressRegistration());
    }
}
