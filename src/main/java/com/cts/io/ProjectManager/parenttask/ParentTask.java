package com.cts.io.ProjectManager.parenttask;

import com.cts.io.ProjectManager.task.Task;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="parentTask")
public class ParentTask {
    private interface Table{
        String ID="ID";
        String NAME="NAME";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name=Table.ID)
    private Integer id;

    @Column(name=Table.NAME)
    private String name;

    @OneToMany(mappedBy = "parent_task",
               cascade = CascadeType.ALL,
               fetch = FetchType.LAZY)
    @JsonIgnore
    @JsonProperty(value="task")
    @JsonManagedReference
    private Set<Task> tasks;

    public ParentTask(Integer id, String name, Set<Task> tasks) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
    }

    public ParentTask(){
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

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
