package org.practice.notable.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.practice.notable.model.Appointment;
import org.practice.notable.service.AppointmentService;

@Path("/doctors")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AppointmentResource {

	private AppointmentService appointmentService = new AppointmentService();
	
	@GET
	@Path("/{doctorId}")
	public List<Appointment> getAllAppointments(@PathParam("doctorId") long doctorId,
												@QueryParam("day") String day)
	{
		return appointmentService.getAllAppointments(doctorId, day);
	}
	
	@DELETE
	@Path("/{doctorId}/appointments/{appointmentId}")
	public void deleteAppointment(@PathParam("doctorId") long doctorId,
								  @PathParam("appointmentId") long appointmentId)
	{
		appointmentService.removeAppointment(doctorId,appointmentId);
	}
	
	@POST
	@Path("/{doctorId}")
	public Response addAppointment(@PathParam("doctorId") long doctorId, Appointment appointment)
			
	{
		Appointment newAppointment = appointmentService.addAppointment(doctorId, appointment);
	
		if (newAppointment == null) {
			return Response.status(Status.BAD_REQUEST)
					  .entity(newAppointment).build();
		}
		else {
			return Response.status(Status.CREATED)
					  .entity(newAppointment).build();
		}
			
		
	}
	
}
