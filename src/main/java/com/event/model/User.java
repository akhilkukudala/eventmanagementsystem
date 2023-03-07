package com.event.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.event.sequenceGenerator.StringPrefixedSequenceIdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user2")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@GenericGenerator(name = "user_seq", strategy = "com.event.sequenceGenerator.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "U_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	@Column(name = "id", updatable = false, nullable = false)
	private String id;
	@NotEmpty
	@Size(min = 3, max = 30, message = "Username should have atleast 3 characters")
	private String username;
	@NotEmpty
	@Size(min = 8, message = "Password should have atleast 8 characters")
	private String password;

	@Transient
	private String passwordConfirm;
	private float totalPrice;
	@OneToMany(mappedBy = "adduser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnoreProperties("adduser")
	private List<Event> cart = new ArrayList<Event>();

	public User() {

	}

	public User(@NotEmpty @Size(min = 3, message = "username should have atleast 3 characters") String username,
			@NotEmpty @Size(min = 8, message = "password should have atleast 8 characters") String password,
			String passwordConfirm) {
		super();
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;

	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Event> getCart() {
		return cart;
	}

	public void setCart(List<Event> cart) {
		this.cart = cart;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", passwordConfirm="
				+ passwordConfirm + ", totalPrice=" + totalPrice + ", cart=" + cart + "]";
	}

}