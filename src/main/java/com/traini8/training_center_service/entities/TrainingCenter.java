package com.traini8.training_center_service.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TrainingCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Center name cannot be empty")
    @Size(max = 40,message = "Center name must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "Center code cannot be empty")
    @Size(min = 12, max = 12, message = "Center code must be exactly 12 characters")
    private String centerCode;

    @Valid
    @NotNull(message = "Address should not be empty")
    @Embedded
    private Address address;

    private Integer studentCapacity;

    @ElementCollection
    @CollectionTable(name = "courses_offered", joinColumns = @JoinColumn(name = "training_center_id"))
    @Column(name = "course")
    private List<String> coursesOffered;

    private Long createdOn;

    @Email(message = "enter a valid Email")
    private  String email;

    @NotNull
    @Pattern(regexp="(^$|[0-9]{10})",message = "phone number should be 10 digits")
    private String phoneNo;

    @PrePersist
    protected void onCreate() {

        this.createdOn = System.currentTimeMillis() / 1000L;
    }
}
