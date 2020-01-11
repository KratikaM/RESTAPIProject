package org.practice.notable.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.practice.notable.database.DatabaseClass;
import org.practice.notable.model.Appointment;
import org.practice.notable.model.Doctor;

public class AppointmentService {
	private static boolean loadDatabase = true;
	private static final int MAX_APPOINTMENT_ALLOWED_AT_SAME_TIME = 3;
	private static final int APPOINTMENT_MINUTE_START_INTERVAL = 15;

	private Map<Long, Appointment> appointments = DatabaseClass.getAppointments();
	private Map<Long, Doctor> doctors = DatabaseClass.getDoctors();

	public AppointmentService() {
		if (loadDatabase) {
			appointments.put(1L,
					new Appointment(1L, 2, "Archer", "Sterling", "2018-05-09", "08:00:00 AM", "New Patient"));
			appointments.put(2L, new Appointment(2L, 2, "Figis", "Cyril", "2018-05-09", "08:30:00 AM", "Follow up"));
			appointments.put(3L, new Appointment(3L, 2, "Gillete", "Ray", "2018-05-09", "09:00:00 AM", "Follow up"));
			appointments.put(4L, new Appointment(4L, 2, "Kane", "Lana", "2018-05-09", "09:30:00 AM", "New Patient"));
			appointments.put(5L, new Appointment(5L, 2, "Poovey", "Pam", "2018-05-09", "10:00:00 AM", "New Patient"));
			loadDatabase = false;
		}

	}

	public List<Appointment> getAllAppointments(long doctorId, String day) {

		List<Appointment> allAppointments = new ArrayList<Appointment>(appointments.values());
		List<Appointment> filterByDayAppointment = new ArrayList<Appointment>();

		for (Appointment appt : allAppointments) {
			if (appt.getDoctorId() == doctorId && appt.getAppointmentDate().equals(LocalDate.parse(day))) {
				filterByDayAppointment.add(appt);
			}

		}

		return filterByDayAppointment;
	}

	public Appointment removeAppointment(long doctorId, long appointmentId) {

		return appointments.remove(appointmentId);
	}

	public Appointment addAppointment(long doctorId, Appointment appointment) {

		Appointment newappointment = null;
		boolean validate = validateAppointment(doctorId, appointment);
		if (validate) {
			boolean canAdd = canAddAppointment(doctorId, appointment);

			if (canAdd) {
				newappointment = new Appointment();
				appointment.setId(appointments.size() + 1);
				appointment.setDoctorId(doctorId);
				appointments.put(appointment.getId(), appointment);
				newappointment = appointment;
			}
		}
		return newappointment;

	}

	// Helper Methods
	private boolean validateAppointment(long doctorId, Appointment appointment) {

		if (!doctors.containsKey(doctorId)) {
			return false;
		}

		if (appointment.getAppointmentDate() == null || appointment.getAppointmentTime() == null) {
			return false;
		}

		try {
			LocalDate.parse(appointment.getAppointmentDate().toString());
		} catch (DateTimeParseException e) {
			return false;
		}

		try {
			LocalTime.parse(appointment.getAppointmentTime().toString(), DateTimeFormatter.ofPattern("hh:mm:ss a"));
		} catch (DateTimeParseException e) {
			return false;
		}

		return true;

	}

	private boolean canAddAppointment(long doctorId, Appointment appointment) {

		int minute = appointment.getAppointmentTime().getMinute();

		if (minute > 59 || minute % APPOINTMENT_MINUTE_START_INTERVAL != 0) {
			return false;
		}
		int count = 0;

		List<Appointment> allAppointments = new ArrayList<Appointment>(appointments.values());
		for (Appointment appt : allAppointments) {

			if (appt.getDoctorId() == doctorId && appt.getAppointmentDate().equals(appointment.getAppointmentDate())
					&& appt.getAppointmentTime().equals(appointment.getAppointmentTime())) {
				count++;
			}
			if (count >= MAX_APPOINTMENT_ALLOWED_AT_SAME_TIME) {
				return false;
			}

		}
		return true;
	}

}
