package cat.udl.eps.entsoftarch.webingogeiadeapi.steps;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import cat.udl.eps.entsoftarch.webingogeiadeapi.WebingoGeiAdeApiApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ContextConfiguration(
	classes = {WebingoGeiAdeApiApplication.class},
	loader = SpringBootContextLoader.class
)
@DirtiesContext
@RunWith(SpringRunner.class)
@WebAppConfiguration
@ActiveProfiles("Test")
public class StepDefs {

    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;

    protected ResultActions result;

    protected ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.wac)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
        this.mapper.registerModule(new JavaTimeModule());
    }

    @Then("^The response code is (\\d+)$")
    public void theResponseCodeIs(int code) throws Throwable {
        result.andExpect(status().is(code));
    }
}
