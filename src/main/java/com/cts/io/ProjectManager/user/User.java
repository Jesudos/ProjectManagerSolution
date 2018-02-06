package com.cts.io.ProjectManager.user;

import com.cts.io.ProjectManager.project.Project;
import com.cts.io.ProjectManager.task.Task;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="User")
public class User {

    private interface Table{
        String ID = "ID";
        String NAME = "NAME";
        String EMAIL_ID = "EMAIL_ID";
        String ROLE = "ROLE";
        String TASK = "TASK";
        String PROJECT = "PROJECT";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Table.ID)
    private Integer id;

    @Column(name = Table.NAME)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Column(name = Table.EMAIL_ID, unique = true)
    private String emailId;

    @Column(name = Table.ROLE, unique = true)
    private String role;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
            )
    @JsonIgnore
    @JsonManagedReference
    @JsonProperty(value="task")
    private Set<Task> tasks;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "project_id",nullable = false)
    @JsonBackReference
    private Project project;



    public User(Integer id, String name, String emailId, String role, Set<Task> tasks, Project project) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.role = role;
        this.tasks = tasks;
        this.project = project;
    }
    public User()
    {
        super();
    }

}
