package com.technoelevate.uploadform.service;

import com.technoelevate.uploadform.dto.Drive;
import com.technoelevate.uploadform.dto.Form;
import com.technoelevate.uploadform.message.UploadPojo;

public interface UploadFormService {

	public Drive uploadForm(Drive drive);

	public Drive getFormByDriveId(int id);

	public Drive deleteFormByDriveId(int id);
	
	public Form findByEmailId(String email,int batchId);
	
	//public Form saveBatch(String email,int batchId);


}
