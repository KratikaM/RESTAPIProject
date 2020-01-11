package org.practice.notable.database;

import java.util.HashMap;
import java.util.Map;

import org.practice.notable.model.Appointment;
import org.practice.notable.model.Doctor;

public class DatabaseClass {
	
	private static Map<Long, Doctor> doctors = new HashMap<>();
	private static Map<Long, Appointment> appointments = new HashMap<>();
	
	public static Map<Long, Doctor> getDoctors() {
		return doctors;
	}
	public static Map<Long, Appointment> getAppointments() {
		return appointments;
	}
	
	

}
