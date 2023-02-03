package com.example.accessingdatamysql;

import java.util.Objects;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MajorRequirements {
  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private int major_id;

  private String major;
  
  private String major_reqs;

  private String class_name;

  public MajorRequirements() {}

  public MajorRequirements(int major_id, String major, String major_reqs, String class_name) {
    this.major_id = major_id;
    this.major = major;
    this.major_reqs = major_reqs;
    this.class_name = class_name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(major_id, major, major_reqs, class_name);
  }

  public int getMajorId() {
    return major_id;
  }

  public void setMajorId(int major_id) {
    this.major_id = major_id;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public String getMajorReqs() {
    return major_reqs;
  }

  public void setMajorReqs(String major_reqs) {
    this.major_reqs = major_reqs;
  }

  public String getClassName() {
    return class_name;
  }

  public void setClassName(String class_name) {
    this.class_name = class_name;
  }
}
