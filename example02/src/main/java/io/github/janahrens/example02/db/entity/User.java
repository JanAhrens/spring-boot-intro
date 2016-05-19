package io.github.janahrens.example02.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// "user" is a reserved keyword in Postgres therefore the default table name needs to be changed.
@Entity(name = "example_user")
public class User {

  @Id
  @GeneratedValue
  private long id;

  @Column
  private String name;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
