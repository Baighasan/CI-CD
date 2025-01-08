package org.hasan.demoproject;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoProjectApplicationTests {

    @Autowired
    // Allows simulation of HTTP requests without starting a real web server
    private MockMvc mockMvc;

    @Test
    public void testDefaultEndpoint() throws Exception {
        // Tests the default endpoint
        mockMvc.perform((get("/")))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("This endpoint is not being listened to"));
    }

    @Test
    public void testSayHelloDefault() throws Exception {
        // Tests the /hello endpoint with no argument
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World!"));
    }

    @Test
    public void testSayHelloWithName() throws Exception {
        // Tests the /hello endpoint with the name argument
        mockMvc.perform(get("/hello").param("name", "Hasan"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello Hasan!"));
    }

}
