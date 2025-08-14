package com.wipro.model;

//import javax.validation.constraints.*;
//import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
// …and other constraints
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class Customer {
    @NotBlank(message = "{customer.name.required}")
    @Size(min = 2, max = 30, message = "{customer.name.size}")
    private String name;

    @NotBlank(message = "{customer.email.required}")
    @Email(message = "{customer.email.invalid}")
    private String email;

    @NotNull(message = "{customer.age.required}")
    @Min(value = 1, message = "{customer.age.invalid}")
    @Max(value = 120, message = "{customer.age.invalid}")
    private Integer age;

    @NotBlank(message = "{customer.gender.required}")
    private String gender;

    @NotNull(message = "{customer.birthday.required}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Pattern(
        regexp = "^(\\d{10}|\\d{3}-\\d{3}-\\d{4}( x\\d{1,5})?)$",
        message = "{customer.phone.invalid}"
    )
    private String phone;

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public LocalDate getBirthday() { return birthday; }
    public void setBirthday(LocalDate birthday) { this.birthday = birthday; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
