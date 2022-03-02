package project.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = ProjectTwoApplication.class)
public abstract class AbstractTest {
	
	protected MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext webAppCont;
	
	protected void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppCont).build();
	}
	
	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper mapToJson = new ObjectMapper();
		return mapToJson.writeValueAsString(obj);
	}
	
	protected <T> T mapFromJson(String json, Class<T> clazz) throws JsonProcessingException {
		ObjectMapper mapFromJson = new ObjectMapper();
		return mapFromJson.readValue(json,clazz);
	}

}
