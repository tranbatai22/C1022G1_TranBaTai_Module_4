package com.example.player_management.dto;

import com.example.player_management.model.Team;

import javax.validation.constraints.*;

public class PlayerDto {
    private int id;
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 100, message = "Tên phải nằm trong khoảng 5 đến 100 kí tự")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Tên không được chưa kí tự đặc biệt")
    private String name;
    @Min(value = 16, message = "Tuổi phải lớn hơn hoặc bằng 16")
    @Max(value = 100, message = "Tuổi phải nhỏ hơn hoặc bằng 100")
    private String dateOfBirth;
    @Pattern(regexp = "^\\d+$", message = "Kinh nghiệm phải là số nguyên dương")
    private String experience;
    private String avatar;

    private String position;
    private Team team;

    public PlayerDto() {
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
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
