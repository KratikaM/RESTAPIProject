package org.practice.notable.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.practice.notable.database.DatabaseClass;
import org.practice.notable.model.Doctor;

public class DoctorService {
	private static boolean loadDatabase = true;
	private Map<Long, Doctor> doctors = DatabaseClass.getDoctors();

	public DoctorService() {

		if (loadDatabase) {
			doctors.put(1l, new Doctor(1, "Julius", "Hibbert"));
			doctors.put(2l, new Doctor(2, "Algernop", "Krieger"));
			doctors.put(3l, new Doctor(3, "Nick", "Riviera"));
			loadDatabase = false;
		}

	}

	public List<Doctor> getAllDoctors() {

		return new ArrayList<Doctor>(doctors.values());
	}

}
