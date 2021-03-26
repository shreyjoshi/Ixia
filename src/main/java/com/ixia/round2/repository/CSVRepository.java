package com.ixia.round2.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.ixia.round2.model.Event;
import com.opencsv.CSVReader;

@Service
public class CSVRepository {
	
	//filename
	public static String csvFile = "campusCodeChallengeData.csv";
	
	//date pattern
	public static DateTimeFormatter format= DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
	
	//reading data from csv file
	private  static List<Event> getEventListfromCSV() {
		List<Event> records = new ArrayList<Event>();
		try  {
			File file =ResourceUtils.getFile("classpath:"+csvFile);
			CSVReader csvReader = new CSVReader(new FileReader(file));
		    String[] values = null;
		    csvReader.skip(1);
		    while ((values = csvReader.readNext()) != null) {
		    	//38d3081d-afa2-460b-81ed-edd79e6059c3, Freshman Orientation, Ahsan Patel, 2020-08-18T12:00:00Z, 2020-08-18T14:00:00Z, Orientation]
		    	Event e =new Event();
		    	for(int i=0; i<values.length;i++) {
		        	String val =values[i];
		        	switch (i) {
						case 0:
							e.setId(val);
							break;
						case 1:
							e.setEventname(val);
							break;
						case 2:
							e.setHost(val);
							break;
						case 3:
							e.setStarttime(LocalDateTime.parse(val,format));
							break;
						case 4:
							e.setEndtime(LocalDateTime.parse(val,format));
							break;
						case 5:
							e.setCategory(val);
							break;
						default:
							break;
					}
		        }
		    	records.add(e);
		    }
		    csvReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return records;
	}
	
	//Method to filter data by category
	public List<Event> findByCategory(String category){
		List<Event> listByCategory = getEventListfromCSV()
										.stream()
										.filter(event -> event.getCategory().equals(category))
										.collect(Collectors.toList());
		
		return listByCategory;
	};

	//Method to get all host for events
	public HashSet<String> getAllHosts(){
		HashSet<String> host = new HashSet<>();
		for(Event e: getEventListfromCSV()) {
			if(!host.contains(e.getHost())) 
				host.add(e.getHost());	
				
		}
		return host;
	}

}
