package com.studies.silvabankapi.entity;

public record ListAccounts(Long id, String name, String cpf, String birth, String email, Address address) {
    public ListAccounts(Account account) {
        this(account.getId(), account.getName(), account.getCpf(), account.getBirth(), account.getEmail(), account.getAddress());
    }
}
