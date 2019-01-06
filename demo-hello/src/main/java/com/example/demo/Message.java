package com.example.demo;

import java.util.Date;

import javax.persistence.*;
import javax.persistence.TemporalType;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="name",nullable = false)
	private String name;
	
	@Column(name="text",nullable = false)
	private String text;
	
	@Column(name="remote_addr",nullable = false)
	private String remoteAddr;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at",updatable = false)
	private Date createdAt;
	
	protected Message() {}
	
	public Message(String name,String text,String remoteAddr) {
		this.name = name;
		this.text = text;
		this.remoteAddr = remoteAddr;
	}
	
	@PrePersist
	public void prePersist() {
		this.createdAt = new Date();
	}
	
	@Override
	public String toString() {
		return String.format("Message[id=%d,name='%s',text='%s']", id,name,text);
	}
	
	public String getName() {return name;}
	public void setName(String name) { this.name = name;}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
	
	

}
