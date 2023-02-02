package com.example.accessingdatamysql;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String name;

  private String email;

  public User() {}

  public User(String nameString, String emailString) {
    this.name = nameString;
    this.email = emailString;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    User user = (User) object;
    return Objects.equals(id, user.id) &&
            Objects.equals(name, user.name) &&
            Objects.equals(email, user.email); 
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email);
  }

  public Integer getId() {
    return id;
  }

  public void setId (Integer id) {
    this.id = id;
  }

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

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", email=" + email + '\'' +
            '}';
  }
}
