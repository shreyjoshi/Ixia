package com.ixia.round2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ixia.round2.model.Event;

//@Repository
public interface EventRepository {

	List<Event> findByCategory(String category);

	@Query(value = "select distinct(host) from event", nativeQuery = true)
	List<String> getAllHosts();

}
