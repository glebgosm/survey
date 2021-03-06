package studio.fabrique.survey;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SurveyControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void addData() throws Exception {
        MockHttpServletRequestBuilder request;
        String requestBody;

        // Add 2 surveys
        requestBody = loadFile("survey1.json");
        request = MockMvcRequestBuilders.post("/surveys?user=admin&password=admin")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Accept", MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
               .andExpect(status().isCreated());

        requestBody = loadFile("survey2.json");
        request = MockMvcRequestBuilders.post("/surveys?user=admin&password=admin")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Accept", MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
               .andExpect(status().isCreated());
    }

    @Test
    public void getSurveys() throws Exception {
        MockHttpServletRequestBuilder request;
        request = MockMvcRequestBuilders.get("/surveys");
        mockMvc.perform(request).andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void deleteSurvey() throws Exception {
        MockHttpServletRequestBuilder request;
        request = MockMvcRequestBuilders.delete("/surveys/0?user=admin&password=admin");
        mockMvc.perform(request).andExpect(status().isOk());
    }

    @Test
    public void changeSurvey() throws Exception {
        String requestBody = loadFile("survey2.json");
        MockHttpServletRequestBuilder request;
        request = MockMvcRequestBuilders
                    .post("/surveys/0?user=admin&password=admin")
                    .content(requestBody)
                    .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
               .andExpect(status().isOk());
    }

    @Test
    public void addNewAnsweredSurvey() throws Exception {
        String requestBody = loadFile("answered_survey1.json");
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.post("/completed_surveys")
                    .content(requestBody)
                    .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request).andExpect(status().isCreated());
    }

    @Test
    public void getAnsweredSurveys() throws Exception {
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.get("/completed_surveys/1000")
                        .header("Accept", MediaType.APPLICATION_JSON);
        mockMvc.perform(request).andExpect(jsonPath("$.length()").value(0));
    }




    private String loadFile(String filename) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(ResourceUtils.getFile("classpath:"+filename)))) {
            while (reader.ready()) {
                sb.append(reader.readLine());
            }
            return sb.toString();
        } catch (Exception e) {
            System.out.println("Error occurred while reading file " + filename);
            return null;
        }

    }

}

