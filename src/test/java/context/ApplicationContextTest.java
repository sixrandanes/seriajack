
package context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.seriajack.Application;

import ch.qos.logback.classic.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ApplicationContextTest {

    private final Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    @Before
    public void setUp() {
        logger.info("initialize ApplicationContextTest");
    }

    @Test
    /**
     * Test context spring
     * 
     * @throws Exception
     */
    public void shouldBeOk() throws Exception {
        logger.info("Spring context test OK");
    }
}
