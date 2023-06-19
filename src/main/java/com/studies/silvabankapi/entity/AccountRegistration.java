package com.studies.silvabankapi.entity;

public record AccountRegistration(String name, String cpf, String birth, String email, AddressRegistration addressRegistration) {
}
