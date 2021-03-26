package com.ixia.round2.controller;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ixia.round2.model.Event;
import com.ixia.round2.service.EventService;

@RestController
@RequestMapping("api/v1")
public class IxiaController {
	
	@Autowired
	EventService service;
	
	/*	Rest api to get the events based on input category will return list of event with status as 200 for the passed category 
		and if not found will send 404 status
	*/
	@GetMapping("/events")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Event>> getEventByCategory(@RequestParam ("category") String category ){
		return ResponseEntity.ok().body(service.getEventByCategory(category));
	}
	
	//API will return list of host, if not found will through exception along with status as 404
	@GetMapping("/hosts")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<HashSet<String>> getHosts(){
		return ResponseEntity.ok().body(service.getHosts());
	}
}
