
package com.pramati.customerrequest.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ACTIVITY")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdBy", "updatedBy", "createdAt", "updatedAt" }, allowGetters = true)
public class Activity extends BaseModel implements Serializable {

	private static final long serialVersionUID = -1871668940183682988L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long actId;
	private Date createDate;
	private String update;

	@ManyToOne
	@JoinColumn(name = "srNumber", nullable = false)
	private ServiceRequest serviceRequest;

	public Long getActId() {
		return actId;
	}

	public void setActId(Long actId) {
		this.actId = actId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
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
			String update, ServiceRequest serviceRequest) {
		super(createdBy, updatedBy, createdAt, updatedAt);
		this.actId = id;
		this.createDate = createDate;
		this.update = update;
		this.serviceRequest = serviceRequest;
	}

	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}

	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}

}
