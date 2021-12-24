package com.technoelevate.uploadform.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;

import com.technoelevate.uploadform.message.Message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Drive implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driveId;

	@NotEmpty(message = Message.NAME_CANNOT_EMPTY)
	private String drivename;

	@FutureOrPresent(message = Message.DATE_MUST_BE_FROM_FUTURE)
	private LocalDate drivedate;

	@NotEmpty(message = Message.OWNER_NAME_CANNOT_BE_EMPTY)
	private String driveOwner;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "drive_id")
	@Valid
	private List<Form> forms;
	
	

	@Override
	public String toString() {
		return "Drive [driveId=" + driveId + ", drivename=" + drivename + ", drivedate=" + drivedate + ", driveOwner="
				+ driveOwner + "]";
	}

}
