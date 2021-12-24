//package com.technoelevate.uploadform;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.technoelevate.uploadform.dto.Drive;
//import com.technoelevate.uploadform.dto.Form;
//import com.technoelevate.uploadform.repository.DriveRepository;
//import com.technoelevate.uploadform.service.UploadFormServiceImpl;
//
//@SpringBootTest
//public class UploadFormServiceImplTest {
//
//	@InjectMocks
//	private UploadFormServiceImpl uploadFormService2;
//
//	@Mock
//	private DriveRepository driveRepository;
//
//	private MockMvc mockMvc;
//
//	private ObjectMapper objectMapper;
//
//	@BeforeEach
//	void setUp() throws Exception {
//		this.mockMvc = MockMvcBuilders.standaloneSetup(uploadFormService2).build();
//		this.objectMapper = new ObjectMapper();
//	}
//
//	@Test
//	void testUploadForm() {
//		Drive drive = new Drive("nodejs", new Date(), "teacno");
//		Form form = new Form(10, "akram", "m", 9108074711l, "akram@gamil.com", "ffg", "dzds", 2005, 75.21, 45.25, 76.54,
//				45.89);
//		List<Form> forms = new ArrayList<>();
//		forms.add(form);
//		drive.setForms(forms);
//		Mockito.when(driveRepository.save(drive)).thenReturn(drive);
//		Drive drive2 = uploadFormService2.uploadForm(drive);
//		assertEquals(drive.getDrivename(), drive2.getDrivename());
//	}
//
//	@Test
//	void testGetFormByDriveId() {
//		Drive drive = new Drive("nodejs", new Date(), "teacno");
//		Form form = new Form(10, "akram", "m", 9108074711l, "akram@gamil.com", "ffg", "dzds", 2005, 75.21, 45.25, 76.54,
//				45.89);
//		List<Form> forms = new ArrayList<>();
//		forms.add(form);
//		drive.setForms(forms);
//		Mockito.when(driveRepository.findByDriveId(Mockito.anyInt())).thenReturn(drive);
//		Drive drive2 = uploadFormService2.getFormByDriveId(Mockito.anyInt());
//		assertEquals(drive.getDrivename(), drive2.getDrivename());
//	}
//
//	@Test
//	void testDeleteFormByDriveId() {
//		Drive drive = new Drive("nodejs", new Date(), "teacno");
//		Form form = new Form(10, "akram", "m", 9108074711l, "akram@gamil.com", "ffg", "dzds", 2005, 75.21, 45.25, 76.54,
//				45.89);
//		List<Form> forms = new ArrayList<>();
//		forms.add(form);
//		drive.setForms(forms);
//		Mockito.when(driveRepository.findByDriveId(Mockito.anyInt())).thenReturn(drive);
//		Drive drive2 = uploadFormService2.getFormByDriveId(Mockito.anyInt());
//		assertEquals(drive.getDrivename(), drive2.getDrivename());
//	}
//
//}
