package pl.sda.travel_agency.controller.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    private Long id_user;

    @NotBlank(message = "Insert your name")
    private String name;


    @NotBlank(message = "Insert your lastname")
    private String lastname;


    @NotBlank(message = "Insert your email")
    @Email(message = "Your email is not valid")
    private String email;


    @NotBlank(message = "Password cant be empty")
    @Size(min = 5, message = "Password too short")
    private String password;


}
