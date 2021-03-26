package com.ixia.round2.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.ixia.round2.model.Event;
import com.ixia.round2.service.EventService;

@SpringBootTest
public class IxiaControllerTest {
	
	//@InjectMocks
	@Autowired
	IxiaController ixiaController;
	
	@Mock
	EventService service;
		
	@Test
	public void testGetEventByCategory(){
		
		when(service.getEventByCategory(any(String.class))).thenReturn(new ArrayList<>());
		String category = "Tour";
		ResponseEntity<List<Event>> response = ixiaController.getEventByCategory(category);
		
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void testGetHosts(){
		//when(service.getHosts()).thenReturn(new ArrayList<>());
		ResponseEntity<List<String>> response =ixiaController.getHosts();
		
		assertEquals(response.getBody().size(), 5);
	}
}
