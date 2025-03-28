package com.tc.model;

import jakarta.persistence.*;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Indexed;

@Entity
@Table(name = "test_cases", indexes = {
        @Index(name = "idx_status", columnList = "status"),
        @Index(name = "idx_priority", columnList = "priority")
})

public class TestCase {

 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id should be valid")
    private Integer id;
    @NotEmpty(message = "Title should be valid")
    private String title;
    private String description;
    
    
    private String status;
    
    
    private String priority;
    
    
    
    @Temporal(TemporalType.TIMESTAMP) // Stores date & time
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP) // Stores date & time
    private Date updatedAt;

    
    enum Status { PENDING, IN_PROGRESS, PASSED, FAILED }
    enum Priority { LOW, MEDIUM, HIGH }
    

    public TestCase() {}

    public TestCase(Integer id, String title, String desc, String status, String priority, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.description = desc;
        this.status = status;
        this.priority = priority;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    
    
    // Auto-set timestamps when inserting/updating
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    // Getters and Setters
    public Integer getId() {
 		return id;
 	}

 	public void setId(Integer id) {
 		this.id = id;
 	}

 	public String getTitle() {
 		return title;
 	}

 	public void setTitle(String title) {
 		this.title = title;
 	}

 	public String getDescription() {
 		return description;
 	}

 	public void setDescription(String description) {
 		this.description = description;
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

 	public Date getCreatedAt() {
 		return createdAt;
 	}

 	public void setCreatedAt(Date createdAt) {
 		this.createdAt = createdAt;
 	}

 	public Date getUpdatedAt() {
 		return updatedAt;
 	}

 	public void setUpdatedAt(Date updatedAt) {
 		this.updatedAt = updatedAt;
 	}

 	
    
    
    
}
    
