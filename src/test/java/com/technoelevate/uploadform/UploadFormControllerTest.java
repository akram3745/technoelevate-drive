package com.technoelevate.uploadform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.technoelevate.uploadform.controller.UploadFormController;
import com.technoelevate.uploadform.dto.Drive;
import com.technoelevate.uploadform.dto.Form;
import com.technoelevate.uploadform.message.ResponseMessage;
import com.technoelevate.uploadform.service.UploadFormService;
@SpringBootTest
class UploadFormControllerTest {
	
	@InjectMocks
	private UploadFormController uploadFormController;

	@Mock
	private UploadFormService uploadFormService;

	private MockMvc mockMvc;
	private ObjectMapper objectMapper;

	@BeforeEach
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.standaloneSetup(uploadFormController).build();
		this.objectMapper = new ObjectMapper();
		this.objectMapper.findAndRegisterModules();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testAddForms() throws UnsupportedEncodingException, Exception {
		Form form = new Form(10, "aa", "dassd", 9108074711l, "akram34@gmail.com", 0, "sd", "fsd", "ssd", 2021, 23.23, 54.54, 54.55, 55.66);
		List<Form> forms = new ArrayList<>();
		forms.add(form);
		LocalDate localDate = LocalDate.now();
		Drive drive = new Drive(10, "cds", localDate, "aca", forms);
		

		Mockito.when(uploadFormService.uploadForm(Mockito.any())).thenReturn(drive);
		String jsonString = objectMapper.writeValueAsString(drive);
		String resultString = mockMvc
				.perform(post("/api/v1/uploadform/addForm").contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(jsonString))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		ResponseMessage readValue = objectMapper.readValue(resultString, ResponseMessage.class);
		Map<String, String> map = (Map<String, String>) readValue.getData();
		for (Map.Entry<String, String> form2 : map.entrySet()) {

			assertEquals(drive.getDriveId(), form2.getValue());
			break;
		}

	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetDrive() throws UnsupportedEncodingException, Exception {
		Form form = new Form(10, "aa", "dassd", 9108074711l, "akram34@gmail.com", 0, "sd", "fsd", "ssd", 2021, 23.23, 54.54, 54.55, 55.66);
		List<Form> forms = new ArrayList<>();
		forms.add(form);
		LocalDate localDate = LocalDate.now();
		Drive drive = new Drive(10, "cds", localDate, "aca", forms);
		
		Mockito.when(uploadFormService.getFormByDriveId(Mockito.anyInt())).thenReturn(drive);
		String jsonString = objectMapper.writeValueAsString(drive);
		String resultString = mockMvc
				.perform(get("/api/v1/uploadform/getDrive/" + 20).contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(jsonString))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		ResponseMessage readValue = objectMapper.readValue(resultString, ResponseMessage.class);

		Map<String, String> map = (Map<String, String>) readValue.getData();
		for (Map.Entry<String, String> mapEntry : map.entrySet()) {
			assertEquals(drive.getDriveId(), mapEntry.getValue());
			break;

		}

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testDeleteById() throws UnsupportedEncodingException, Exception {
		Form form = new Form(10, "aa", "dassd", 9108074711l, "akram34@gmail.com", 0, "sd", "fsd", "ssd", 2021, 23.23, 54.54, 54.55, 55.66);
		List<Form> forms = new ArrayList<>();
		forms.add(form);
		LocalDate localDate = LocalDate.now();
		Drive drive = new Drive(10, "cds", localDate, "aca", forms);
		
		Mockito.when(uploadFormService.deleteFormByDriveId(Mockito.anyInt())).thenReturn(drive);
		String jsonString = objectMapper.writeValueAsString(drive);
		String resultString = mockMvc
				.perform(delete("/api/v1/uploadform/delete/" + 20).contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(jsonString))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		ResponseMessage readValue = objectMapper.readValue(resultString, ResponseMessage.class);
		Map<String, String> map = (Map<String, String>) readValue.getData();
		for (Map.Entry<String, String> mm : map.entrySet()) {
			assertEquals(drive.getDriveId(), mm.getValue());
			break;
		}

	}


	

}
