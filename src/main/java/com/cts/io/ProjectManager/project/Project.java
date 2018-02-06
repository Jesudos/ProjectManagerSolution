package com.cts.io.ProjectManager.project;

import com.cts.io.ProjectManager.task.Task;
import com.cts.io.ProjectManager.user.User;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="project")
public class Project {
     private interface Table{
         String ID="ID";
         String NAME="NAME";
         String STARTDATE="START_DATE";
         String ENDDATE="END_DATE";
         String STATUS="STATUS";
         String PRIORITY="PRIORITY";
     }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name=Table.ID)
    private Integer id;

    @Column(name=Table.NAME)
    private String name;

    @Column(name = Table.STARTDATE, nullable= false)
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date startDate;

    @Column(name = Table.ENDDATE, nullable= false)
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date endDate;

    @Column(name=Table.STATUS)
    private Integer status;

    @Column(name=Table.PRIORITY)
    private Integer priority;

    @OneToMany(mappedBy ="project",cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonManagedReference
    @JsonProperty(value="user")
    private Set<Task> tasks;

    @OneToMany(mappedBy = "project",
                cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonManagedReference
    @JsonProperty(value="user")
    private Set<User> users;

    public Project(Integer id, String name, Date startDate, Date endDate, Integer status, Integer priority, Set<User> users) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.priority = priority;
        this.users = users;
    }

    public Project(Integer id, String name, Date startDate, Date endDate, Integer status, Integer priority) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.priority = priority;
    }

    public Project(){
        super();
    }

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
