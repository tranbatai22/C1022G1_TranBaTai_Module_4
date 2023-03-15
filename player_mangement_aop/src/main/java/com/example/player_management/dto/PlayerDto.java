package com.example.player_management.dto;

import com.example.player_management.model.Position;
import com.example.player_management.model.Team;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class PlayerDto implements Validator {
    private int id;

//    @NotBlank(message = "Tên không được để trống")
//    @Size(min = 5, max = 100, message = "Tên phải nằm trong khoảng 5 đến 100 kí tự")
//    @Pattern(regexp = "^[a-zA-Z]*$", message = "Tên không được chưa kí tự đặc biệt")
    private String name;
//    @Min(value = 16, message = "Tuổi phải lớn hơn hoặc bằng 16")
//    @Max(value = 100, message = "Tuổi phải nhỏ hơn hoặc bằng 100")
    private String age;
//    @Pattern(regexp = "^[1-9]\\d*$", message = "Kinh nghiệm phải là số nguyên dương.")
    private String experience;
    private String avatar;
    private Position position;
    private Team team;
    private boolean status;
    public PlayerDto() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return age;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.age = dateOfBirth;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
