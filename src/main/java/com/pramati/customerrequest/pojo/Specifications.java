package com.pramati.customerrequest.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "SPECIFICATIONS")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdBy", "updatedBy", "createdAt", "updatedAt" }, allowGetters = true)
public class Specifications extends BaseModel implements Serializable {

	private static final long serialVersionUID = 4131951736733354652L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	@Column(name = "SPECS_NAME")
	private String specsName;
	@Column(name = "SPECS")
	private String specs;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getSpecsName() {
		return specsName;
	}

	public void setSpecsName(String specsName) {
		this.specsName = specsName;
	}

	public String getSpecs() {
		return specs;
	}

	public void setSpecs(String specs) {
		this.specs = specs;
	}

	public Specifications(String createdBy, String updatedBy, Date createdAt, Date updatedAt, int id, String specsName,
			String specs) {
		super(createdBy, updatedBy, createdAt, updatedAt);
		Id = id;
		this.specsName = specsName;
		this.specs = specs;
	}

	public Specifications() {
		super();
	}

}
