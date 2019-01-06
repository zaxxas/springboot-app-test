package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.MessageRepository;

public interface ServiceInterface {
	
	public List<Message> getRecentMessages(Integer n);
	
	@Transactional
	public void save(Message message);

	@Transactional
	public void delete(long id);


}
