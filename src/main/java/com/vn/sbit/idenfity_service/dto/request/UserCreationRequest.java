package com.vn.sbit.idenfity_service.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserCreationRequest {
    @Size(min=3,message="USER_USERNAME_INVALID") //message đưa vào name của error, phải đúng tên enum
    @NotNull(message = "Username can not null")
    private String userName;

    //spring-sta-validation
    @Size(min = 8,message = "USER_PASSWORD_INVALID")
    @NotNull(message = "Password can not null")
    private String passWord;

    private String firstName;

    private String lastName;


    private LocalDate dob;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
