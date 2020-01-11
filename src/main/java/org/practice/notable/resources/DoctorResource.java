package org.practice.notable.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.practice.notable.model.Doctor;
import org.practice.notable.service.DoctorService;

@Path("/doctors")

public class DoctorResource {
	
	DoctorService doctorService = new DoctorService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Doctor> getDoctors(){
		
		return doctorService.getAllDoctors();
		
	}
			
	

}
