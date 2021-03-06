package br.com.domainconsult.apir.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="employee",schema="devsoa")

public class Employee implements Serializable{
	
	@Id
    @Column(name="emp_id")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="sequence")
	@SequenceGenerator(name="sequence", sequenceName="EMP_SEQ")
	private Long empid;
	
	@Column(name="emp_name")
	private String empname;
	
	@Column(name="emp_alias")
	private String empalias;
	
	@Column(name="emp_password")
	private String emppassword;
	
	@Column(name="emp_dni")
	private String empdni;
	
	@Column(name="emp_email")
	private String empemail;

	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	@NotEmpty(message = "{employee.empname.notempty}")
	@Length(min = 5, max = 200, message = "{employee.empname.length}")
	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmpalias() {
		return empalias;
	}

	public void setEmpalias(String empalias) {
		this.empalias = empalias;
	}

	public String getEmppassword() {
		return emppassword;
	}

	public void setEmppassword(String emppassword) {
		this.emppassword = emppassword;
	}

	public String getEmpdni() {
		return empdni;
	}

	public void setEmpdni(String empdni) {
		this.empdni = empdni;
	}

	public String getEmpemail() {
		return empemail;
	}

	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}	

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empalias=" + empalias + ", emppassword="
				+ emppassword + ", empdni=" + empdni + ", empemail=" + empemail + "]";
	}
	
}
