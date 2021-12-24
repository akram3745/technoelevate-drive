package com.technoelevate.uploadform.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.technoelevate.uploadform.message.Message;

import ch.qos.logback.core.status.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Form implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int formId;

	@NotEmpty(message = Message.NAME_CANNOT_EMPTY)
	private String name;

	@NotEmpty(message = Message.BRANCH_NAME_CANNOT_BE_EMPTY)
	private String branch;

	@Range(min = 6000000000l, max = 9999999999l, message = Message.PLEASE_ENTER_THE_CORRECT_NUMBER)
	private long contactNo;

	@Pattern(regexp = "[a-zA-Z]+[0-9]*[@][a-z]*[.][a-z]{2,3}")
	private String email;
	
	private int batchId;

	private String status;

	@NotEmpty(message = Message.DEGREE_CANNOT_BE_NULL)
	private String degree;

	@NotEmpty(message = Message.STREAM_CANNOT_BE_NULL)
	private String stream;

	@Range(min = 2000, max = 2099, message = Message.ENTER_THE_CORRECT_PASSOUT_YEAR)
	private int passoutYear;

	@Digits(integer = 2, fraction = 2, message = Message.ENTER_THE_CORRECT_PERCENTAGE)
	private double tenthPercentage;

	@Digits(integer = 2, fraction = 2, message = Message.ENTER_THE_CORRECT_PERCENTAGE)
	private double twelvethPercentage;

	@Digits(integer = 2, fraction = 2, message = Message.ENTER_THE_CORRECT_PERCENTAGE)
	private double degreeAggregate;

	@Digits(integer = 2, fraction = 2, message = Message.ENTER_THE_CORRECT_PERCENTAGE)
	private double masterAggregate;

	@Override
	public String toString() {
		return "Form [formId=" + formId + ", name=" + name + ", branch=" + branch + ", contactNo=" + contactNo
				+ ", email=" + email + ", status=" + status + ", degree=" + degree + ", stream=" + stream
				+ ", passoutYear=" + passoutYear + ", tenthPercentage=" + tenthPercentage + ", twelvethPercentage="
				+ twelvethPercentage + ", degreeAggregate=" + degreeAggregate + ", masterAggregate=" + masterAggregate
				+ "]";
	}

	

}
