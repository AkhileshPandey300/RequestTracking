package com.pramati.customerrequest.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ACTIVITY")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdBy", "updatedBy", "createdAt", "updatedAt" }, allowGetters = true)
public class Activity extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1871668940183682988L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long actId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "accountId")
	private String srNumber;
	private String update;

	public Long getActId() {
		return actId;
	}

	public void setActId(Long actId) {
		this.actId = actId;
	}

	public String getSrNumber() {
		return srNumber;
	}

	public void setSrNumber(String srNumber) {
		this.srNumber = srNumber;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public Activity() {

	}

	public Activity(String createdBy, String updatedBy, Date createdAt, Date updatedAt, Long id, Date createDate,
			String srNumber, String update) {
		super(createdBy, updatedBy, createdAt, updatedAt);
		this.actId = id;
		this.createDate = createDate;
		this.srNumber = srNumber;
		this.update = update;
	}

}
