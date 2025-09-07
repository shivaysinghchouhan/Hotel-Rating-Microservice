package com.user.entity;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id")
    private Integer userId;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "about_user")
    private String aboutUser;
    
    @Column(name="user_name")
    private String userName;

    // Getters and Setters
    @Transient
    private List<Rating> listOfRating;
    

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getAboutUser() {
        return aboutUser;
    }
    public void setAboutUser(String aboutUser) {
        this.aboutUser = aboutUser;
    }
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Rating> getListOfRating() {
		return listOfRating;
	}
	public void setListOfRating(List<Rating> listOfRating) {
		this.listOfRating = listOfRating;
	}
    
    
}
