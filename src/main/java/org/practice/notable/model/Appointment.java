package org.practice.notable.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Appointment {
	
	private long id;
	private long doctorId;
	private String patientFirstName;
	private String patientLastName;
	private LocalTime appointmentTime;
	private LocalDate appointmentDate;
	private String kind;
	
	public Appointment() {
		
	}
	
	public Appointment(long id, long doctorId, String patientFirstName, String patientLastName,
			String appointmentDate, String appointmentTime,  String kind) {

		this.id = id;
		this.doctorId = doctorId;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.appointmentDate = LocalDate.parse(appointmentDate);
		this.appointmentTime = LocalTime.parse(appointmentTime, DateTimeFormatter.ofPattern("HH:mm:ss a")) ;
		this.kind = kind;
	}




	public long getId() {
		return id;
	}
	


	public void setId(long id) {
		this.id = id;
	}
	public String getPatientFirstName() {
		return patientFirstName;
	}
	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}
	public String getPatientLastName() {
		return patientLastName;
	}
	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}


	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}




	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}




	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}




	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}




	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	

	

}
