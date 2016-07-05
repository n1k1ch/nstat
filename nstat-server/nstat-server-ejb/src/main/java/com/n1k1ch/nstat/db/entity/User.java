package com.n1k1ch.nstat.db.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ncherevkov on 7/5/2016.
 */
@XmlRootElement(name = "user")
public class User {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute
	public String getName() {
		return name;
	}
}
