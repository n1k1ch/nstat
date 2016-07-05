package com.n1k1ch.nstat.db.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

/**
 * Created by ncherevkov on 7/5/2016.
 */
@Entity
@Table(name = "entry")
@XmlRootElement(name = "entry")
public class Entry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "amount")
	private BigDecimal amount;

	@Column(name = "currency")
	private Currency currency;

	@Column(name = "comment")
	private String comment;

	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@XmlAttribute
	public Long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute
	public String getName() {
		return name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	@XmlAttribute
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	@XmlAttribute
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getComment() {
		return comment;
	}

	@XmlAttribute
	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	@XmlAttribute
	public void setDate(Date date) {
		this.date = date;
	}
}
