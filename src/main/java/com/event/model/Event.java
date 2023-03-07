package com.event.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import org.hibernate.annotations.Parameter;

import com.event.sequenceGenerator.StringPrefixedSequenceIdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "event")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_seq")
	@GenericGenerator(name = "prod_seq", strategy = "com.event.sequenceGenerator.StringPrefixedSequenceIdGeneratorEvent", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "E_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	@Column(name = "id", updatable = false, nullable = false)

	private String id;
	@NotEmpty
	private String ename;
	@NotEmpty
	private String evenue;
	@NotEmpty
	private String eorganizer;
	@NotNull
	private float price;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties("cart")
	private User adduser;

	public User getAdduser() {
		return adduser;
	}

	public void setAdduser(User adduser) {
		this.adduser = adduser;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEvenue() {
		return evenue;
	}

	public void setVenue(String evenue) {
		this.evenue = evenue;
	}

	public String getEorganizer() {
		return eorganizer;
	}

	public void setEorganizer(String eorganizer) {
		this.eorganizer = eorganizer;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {

		return "Event [id=" + id + ", ename=" + ename + ", evenue=" + evenue + ", eorganizer=" + eorganizer + ", price="
				+ price + "]";
	}

}