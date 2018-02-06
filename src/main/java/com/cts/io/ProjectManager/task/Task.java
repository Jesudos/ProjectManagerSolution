package com.cts.io.ProjectManager.task;

import com.cts.io.ProjectManager.parenttask.ParentTask;
import com.cts.io.ProjectManager.project.Project;
import com.cts.io.ProjectManager.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Task")
public class Task {

    private interface Table{
         String ID="ID";
         String NAME="NAME";
         String START_DATE="START_DATE";
         String END_DATE="END_DATE";
         String STATUS="STATUS";
         String PRIORITY="PRIORITY";
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name=Table.ID)
    private Integer id;

    @Column(name = Table.START_DATE, nullable= false)
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date startDate;

    @Column(name = Table.END_DATE, nullable= false)
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date endDate;

    @Column(name=Table.STATUS)
    private String status;

    @Column(name=Table.PRIORITY)
    private String priority;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id", nullable = false)
    @JsonBackReference
    private Project project;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_task_id", nullable = false)
    @JsonBackReference
    private ParentTask parent_task;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    public Task(Integer id, Date startDate, Date endDate, String status, String priority, Project project, ParentTask parent_task, User user) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.priority = priority;
        this.project = project;
        this.parent_task = parent_task;
        this.user = user;
    }

    public Task(){
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ParentTask getParent_task() {
        return parent_task;
    }

    public void setParent_task(ParentTask parent_task) {
        this.parent_task = parent_task;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
