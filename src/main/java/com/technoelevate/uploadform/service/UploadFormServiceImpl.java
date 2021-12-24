package com.technoelevate.uploadform.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.technoelevate.uploadform.dto.Drive;
import com.technoelevate.uploadform.dto.Form;
import com.technoelevate.uploadform.exception.CustomException;
import com.technoelevate.uploadform.message.Message;
import com.technoelevate.uploadform.repository.DriveRepository;
import com.technoelevate.uploadform.repository.FormRepository;

@Transactional
@Service
public class UploadFormServiceImpl implements UploadFormService {

	@Autowired
	private DriveRepository driveRepository;

	@Autowired
	private FormRepository formRepository;

	private String onboard = "onboard";
	private String registered = "Registered";
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Drive uploadForm(Drive drive) {
		try {
			if (drive.getDriveId() != 0) {
				Drive drive3 = driveRepository.findByDriveId(drive.getDriveId());
				if (drive3 != null) {
					List<Form> forms = drive.getForms();
					for (Form form : forms) {
						form.setStatus(onboard);
					}
					drive3.setForms(forms);
					drive3.setDrivedate(drive.getDrivedate());
					drive3.setDrivename(drive.getDrivename());
					drive3.setDriveOwner(drive.getDrivename());
					return driveRepository.save(drive3);
				} else {
					throw new CustomException(Message.DRIVE_ID_IS_NULL);
				}
			}
			List<Form> forms = drive.getForms();
			for (Form form : forms) {
				form.setStatus(registered);
			}
			drive.setForms(forms);

			return driveRepository.save(drive);
		} catch (Exception e) {
			throw new CustomException(Message.SOMETHIN_WENT_WRONG);
		}

	}

	@Override
	public Drive getFormByDriveId(int id) {

		try {
			return driveRepository.findByDriveId(id);
		} catch (Exception e) {
			throw new CustomException(Message.SOMETHIN_WENT_WRONG);
		}

	}

	@Override
	public Drive deleteFormByDriveId(int id) {

		try {
			Drive drive2 = driveRepository.findByDriveId(id);
			if (drive2 != null) {
				driveRepository.delete(drive2);
				return drive2;
			} else {
				throw new CustomException(Message.DRIVE_ID_IS_NULL);
			}

		} catch (Exception e) {
			throw new CustomException(Message.SOMETHIN_WENT_WRONG);
		}

	}

	@Override
	public Form findByEmailId(String email,int batchId) {
		try {
			Form form = formRepository.findByEmail(email);
			if (form == null) {
				return new Form();
			}
			form.setBatchId(batchId);
			Form form2 = formRepository.save(form);
			return form;
		} catch (Exception e) {
			throw new CustomException(Message.SOMETHIN_WENT_WRONG);
		}
	}

//	@Override
//	public Form saveBatch(String email,int batchId) {
//		try {
//			
//			Form form = formRepository.findByEmail(email);
//			form.setBatchId(batchId);
//			return formRepository.save(form);
//			
//		} catch (Exception e) {
//			throw new CustomException(Message.SOMETHIN_WENT_WRONG);
//		}
//		
//	}

	
}
