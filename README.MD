RESTAPIProject

RESTAPIProject for doctor's calendar About the project:-

1. Created the REST API using JAX-RS Jersey Framework
2. All request and response is accepted in JSON format
3. Tested the project in POSTMAN
How to run the requests:-

1. Get All Doctors. 
    REQUEST TYPE : GET  
    URL : http://localhost:{portnumber}/notableHealth/webapi/doctors 
    RESPONSE TYPE: JSON

2. Get list of appointments for particular doctor on particular day. Accepts date in the format(YYYY-MM-DD) as query param (day). 	
	REQUEST TYPE : GET 
	URL : http://localhost:{portnumber}/notableHealth/webapi/doctors/{doctorId}?day={date} 
	RESPONSE TYPE: JSON

3. Delete an existing appointment from a doctor's calendar. 
	REQUEST TYPE : DELETE 
	URL : http://localhost:{portnumber}/notableHealth/webapi/doctors/{doctorId}/appointments/{appointmentId} 
	RESPONSE TYPE: JSON . Status 200 OK Status 400 Bad Request

4. Add a new appoitment to a doctor's calendar. Takes the appointment details as JSON. Time format (HH:mm:ss) is in 24 hr 

	REQUEST TYPE : POST 
	URL : http://localhost:{portnumber}/notableHealth/webapi/doctors/{doctorId} 
	RESPONSE TYPE: JSON . Status 201 CREATED - For successful appointment add 
	                      Status 400 Bad Request - For Failed Validations 
	Example of JSON Body as Input in header field: { "appointmentDate": "2018-05-09", "appointmentTime": "09:30:00", "kind": "New Patient", "patientFirstName": "Kane", "patientLastName": "Lana" }