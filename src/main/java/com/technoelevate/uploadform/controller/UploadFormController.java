package com.technoelevate.uploadform.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technoelevate.uploadform.dto.Drive;
import com.technoelevate.uploadform.dto.Form;
import com.technoelevate.uploadform.message.Message;
import com.technoelevate.uploadform.message.ResponseMessage;
import com.technoelevate.uploadform.message.UploadPojo;
import com.technoelevate.uploadform.service.UploadFormService;

@RestController
@RequestMapping("/api/v1/uploadform")
public class UploadFormController {

	@Autowired
	private UploadFormService uploadFormService;

	@PostMapping(path = "/drive")
	public ResponseEntity<ResponseMessage> addForms(@Valid @RequestBody Drive drive) {
		System.out.println(drive);
		Drive uploadForm = uploadFormService.uploadForm(drive);
		System.out.println(uploadForm);
		if (uploadForm != null) {
			return new ResponseEntity<ResponseMessage>(new ResponseMessage(HttpStatus.OK.value(), new Date(), false,
					Message.DATA_ADDED_SUCCESSFULL, uploadForm), HttpStatus.OK);
		}
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(HttpStatus.BAD_REQUEST.value(), new Date(),
				false, Message.SOMETHIN_WENT_WRONG, uploadForm), HttpStatus.BAD_REQUEST);

	}

	@GetMapping(path = "/drive/{id}")
	public ResponseEntity<ResponseMessage> getDrive(@PathVariable("id") Integer id) {
		Drive drive = uploadFormService.getFormByDriveId(id);
		System.out.println(drive);
		if (drive != null) {
			return new ResponseEntity<ResponseMessage>(
					new ResponseMessage(HttpStatus.OK.value(), new Date(), false, Message.SUCCESSFUL_FETCH_DATA, drive),
					HttpStatus.OK);
		}
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(HttpStatus.BAD_REQUEST.value(), new Date(),
				false, Message.SOMETHIN_WENT_WRONG, drive), HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping(path = "/drive/{id}")
	public ResponseEntity<ResponseMessage> deleteById(@PathVariable("id") Integer id) {
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(HttpStatus.OK.value(), new Date(), false,
				Message.DELETE, uploadFormService.deleteFormByDriveId(id)), HttpStatus.OK);
	}

	@GetMapping(path = "/form/{email}/{batchId}")
	public ResponseEntity<Form> getForm(@PathVariable("email") String email,@PathVariable("batchId") int batchId) {
		Form form = uploadFormService.findByEmailId(email,batchId);
		if (form != null) {
			return new ResponseEntity<Form>(form, HttpStatus.OK);
		}
		return new ResponseEntity<Form>(form, HttpStatus.BAD_REQUEST);
	}
//	@GetMapping(path = "/form/{email}/{batchId}")
//	public ResponseEntity<Form> saveBatch(@PathVariable("email") String email,@PathVariable("batchId") int batchId) {
//		Form form = uploadFormService.saveBatch(email,batchId);
//		if (form != null) {
//			return new ResponseEntity<Form>(form, HttpStatus.OK);
//		}
//		return new ResponseEntity<Form>(form, HttpStatus.BAD_REQUEST);
//	}

}
