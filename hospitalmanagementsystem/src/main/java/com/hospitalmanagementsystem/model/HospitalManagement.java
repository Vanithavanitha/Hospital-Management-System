package com.hospitalmanagementsystem.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import org.springframework.boot.context.properties.bind;


	@Entity
	@Table (name = "Appoinments")
	
	public class HospitalManagement {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		
		private String Name;
		private String DoctorName;
		private String emailId;
		private String Departments;
		private double time;
		
		public HospitalManagement() {
		
		}
		
		public HospitalManagement(String Name, String DoctorName, String emailId,String Departments,double time) {
			this.Name = Name;
			this.DoctorName =DoctorName;
			this.emailId = emailId;
			this.Departments=Departments;
			this.time=time;
		}
		
		@Column(name="Name",nullable=false)
		@GeneratedValue(strategy = GenerationType.AUTO)
		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}
		
		@Column(name = "Doctor_name", nullable = false)
		public String getDoctorName() {
			return DoctorName;
		}

		public void setDoctorName(String doctorName) {
			DoctorName = doctorName;
		}
		@Column(name = "Departments", nullable = false)
		public String getDepartments() {
			return Departments;
		}

		public void setDepartments(String departments) {
			Departments = departments;
		}
		
		@Column(name = "email_address", nullable = false)
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		@Column(name="Time",nullable=false)
		public double getTime() {
			return time;
		}

		public void setTime(double time) {
			this.time = time;
		}


		@Override
		public String toString() {
			return "Employee [Name=" + Name + ", DoctorName=" + DoctorName + ", Departments=" + Departments + ", emailId=" + emailId
					+ ",Time="+time+"]";
		}
		
	}



