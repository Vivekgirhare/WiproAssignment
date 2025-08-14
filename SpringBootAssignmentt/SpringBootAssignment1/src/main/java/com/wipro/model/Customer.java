package com.wipro.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer 
{
	@NotBlank(message = "{name.required}")
    @Size(min = 2, max = 30, message = "{name.size}")
    private String name;

    @NotBlank(message = "{email.required}")
    @Email(message = "{email.invalid}")
    private String email;

    @NotNull(message = "{age.required}")
    @Min(value = 1, message = "{age.min}")
    private Integer age;

    @NotBlank(message = "{gender.required}")
    private String gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    @NotNull(message = "{birthday.required}")
    private Date birthday;

    @Pattern(regexp = "^(\\d{10}|\\d{3}-\\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4} x\\d+)$", message = "{phone.invalid}")
    private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
    
    

}