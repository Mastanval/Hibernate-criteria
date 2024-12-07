package com.klu.Hcql;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.Criteria;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "project_name")
  private String projectName;

  @Column(name = "duration")
  private int duration; // Duration in days

  @Column(name = "budget")
  private double budget;

  @Column(name = "team_lead")
  private String teamLead;

  // Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public double getBudget() {
    return budget;
  }

  public void setBudget(double budget) {
    this.budget = budget;
  }

  public String getTeamLead() {
    return teamLead;
  }

  public void setTeamLead(String teamLead) {
    this.teamLead = teamLead;
  }
}

// ClientDemo.java
