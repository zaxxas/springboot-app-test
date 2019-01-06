package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long>{
/*public interface MessageRepository extends CrudRepository<Message,Long>{*/

	List<Message> findByOrderByIdDesc(Pageable pageable);
}
