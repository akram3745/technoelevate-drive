package com.technoelevate.uploadform.message;

import java.util.List;

import com.technoelevate.uploadform.dto.Drive;
import com.technoelevate.uploadform.dto.Form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadPojo {
	
	private Drive drive;
	private List<Form> forms;

}
