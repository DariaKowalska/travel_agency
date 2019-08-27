package pl.sda.travel_agency.controller.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    private Long id_user;

    @NotBlank(message = "Wprowadź imię")
    private String name;


    @NotBlank(message = "Wprowadź nazwisko")
    private String lastname;


    @NotBlank(message = "Wprowadź email")
    @Email(message = "Email jest niepoprawny")
    private String email;


    @NotBlank(message = "Wprowadź hasło")
    @Size(min = 5, message = "Hasło za krótkie")
    private String password;


}
