package com.studies.silvabankapi.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String public_place;
    private String neighborhood;
    private String zip_code;
    private String city;
    private String uf;
    private String complement;
    private String address_number;

    public Address(AddressRegistration data) {
        this.public_place = data.public_place();
        this.neighborhood = data.neighborhood();
        this.zip_code = data.zip_code();
        this.city = data.city();
        this.uf = data.uf();
        this.complement = data.complement();
        this.address_number = data.address_number();
    }
}
