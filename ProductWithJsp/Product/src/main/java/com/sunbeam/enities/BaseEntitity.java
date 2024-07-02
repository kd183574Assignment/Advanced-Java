package com.sunbeam.enities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class BaseEntitity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CreationTimestamp
	@Column(name = "created_time")
	private LocalDate createdOn;
	
	@UpdateTimestamp
	@Column (name = "updated_time")
	private LocalDateTime updateOn;
	
	

	public BaseEntitity() {
		super();
	}
	
	

	public BaseEntitity(Long id, LocalDate createdOn, LocalDateTime updateOn) {
		super();
		this.id = id;
		this.createdOn = createdOn;
		this.updateOn = updateOn;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(LocalDateTime updateOn) {
		this.updateOn = updateOn;
	}



	@Override
	public String toString() {
		return "BaseEntitity [id=" + id + ", createdOn=" + createdOn + ", updateOn=" + updateOn + "]";
	}
}
