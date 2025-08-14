package com.wipro.model;

import jakarta.validation.constraints.*;
import java.util.List;

public class Student {
    @Size(min = 3, max = 30, message = "{firstName.size}")
    private String firstName;

    @Size(min = 3, max = 30, message = "{lastName.size}")
    private String lastName;

    @NotNull(message = "{gender.notnull}")
    private String gender;

    @NotNull(message = "{dob.notnull}")
    private String dateOfBirth;

    @NotBlank(message = "{email.notblank}")
    @Email(message = "{email.invalid}")
    private String email;

    @NotNull(message = "{section.notnull}")
    private String section;

    @NotNull(message = "{country.notnull}")
    private String country;

    private Boolean firstAttempt;

    @NotEmpty(message = "{subjects.notempty}")
    private List<String> subjects;

    // Getters and setters...
}
