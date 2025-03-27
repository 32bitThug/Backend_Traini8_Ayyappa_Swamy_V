package com.traini8.training_center_service.entities;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @NotBlank(message = "Street cannot be empty")
    private String detailedAddress;

    @NotBlank(message = "City cannot be empty")
    private String city;

    @NotBlank(message = "State cannot be empty")
    private String state;

    @NotBlank(message = "Pin Code cannot be empty")
    @Pattern(regexp = "^\\d{6}$", message = "Pin Code must be exactly 6 digits")
    private String pinCode;
}
