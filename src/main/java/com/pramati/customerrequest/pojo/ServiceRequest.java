package com.pramati.customerrequest.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "SERVICEREQUEST")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdBy", "updatedBy", "createdAt", "updatedAt" }, allowGetters = true)
public class ServiceRequest extends BaseModel implements Serializable {

	private static final long serialVersionUID = -4210395994966445661L;
	@Id
	@Column(name = "SRNUMBER", nullable = false)
	private String srNumber;
	private String title;
	private long accountId;
	private long contactId;
	private String status;
	private Date openDate;
	private Date closeDate;
	private String description;

	@JsonIgnore
	@OneToMany(mappedBy = "serviceRequest")
	private List<Activity> activityList = new ArrayList<>();

	public String getSrNumber() {
		return srNumber;
	}

	public void setSrNumber(String srNumber) {
		this.srNumber = srNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOpenDate() {
		return openDate;
	}

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ServiceRequest(String createdBy, String updatedBy, Date createdAt, Date updatedAt, String srNumber,
			String title, long accountId, long contactId, String status, Date openDate, Date closeDate,
			String description, List<Activity> activities) {
		super(createdBy, updatedBy, createdAt, updatedAt);
		this.srNumber = srNumber;
		this.title = title;
		this.accountId = accountId;
		this.contactId = contactId;
		this.status = status;
		this.openDate = openDate;
		this.closeDate = closeDate;
		this.description = description;
		this.activityList = activities;
	}

	public ServiceRequest() {

	}

	public List<Activity> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<Activity> activityList) {
		this.activityList = activityList;
	}

}
