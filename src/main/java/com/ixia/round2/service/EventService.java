package com.ixia.round2.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ixia.round2.exception.EventException;
import com.ixia.round2.model.Event;
import com.ixia.round2.repository.CSVRepository;

@Service
public class EventService {

	@Autowired
	CSVRepository repo;
	
	public List<Event> getEventByCategory(String category){
		List<Event> eventList = repo.findByCategory(category);
		if(eventList.isEmpty())
			throw new EventException("category",category);
		else
			return eventList;
	}

	public HashSet<String> getHosts() {
		// TODO Auto-generated method stub
		HashSet<String> hosts = repo.getAllHosts();
		if(hosts.isEmpty())
			throw new EventException();
		else
			return hosts;
	}
}
