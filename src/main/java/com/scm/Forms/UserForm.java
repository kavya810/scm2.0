package com.scm.Forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserForm {

    @NotBlank(message = "Username is required")
    @Size(min = 3 , message="minimum 3 character is required")
    private String name;
    @Email(message = "Invalid email Address")    
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "password is required")
    @Size(min = 6 , message = "min 6 is required" )
    private String password;
    @NotBlank(message = "about is required")
    private String about;
    @Size(min = 10 , max = 12 , message = "invalid phonenumber")
    private String phoneNumber;
}
