package com.klef.soa.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BloodDonor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bloodDonorId;

	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 10, nullable = false)
	private String type;

	@Column(nullable = false)
	private boolean status;

	@Column(length = 100, nullable = false)
	private String location;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public Long getBloodDonorId() {
		return bloodDonorId;
	}

	public void setBloodDonorId(Long bloodDonorId) {
		this.bloodDonorId = bloodDonorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "BloodDonor [bloodDonorId=" + bloodDonorId + ", name=" + name + ", type=" + type + ", status=" + status
				+ ", location=" + location + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
