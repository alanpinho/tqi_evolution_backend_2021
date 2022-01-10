package com.evolution.tqi.app.register_user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Automatically generated. You don't need to care about this parameter")
    private Long id;

    @Schema(description = "The user's city", example = "Uberlândia")
    private String city;

    @Schema(description = "The user's state", example = "Minas Gerais")
    private String state;

    @Schema(description = "The street where the user lives", example = "Av. Rondon Pacheco")
    private String street;

    @Schema(description = "The house number in the street", example = "4600")
    private String houseNumber;

    @Schema(description = "The district or neighbourhood where user lives", example = "Tibery")
    private String district;

    @Schema(description = "The zip code", example = "38405-142")
    private String zipCode;

}
