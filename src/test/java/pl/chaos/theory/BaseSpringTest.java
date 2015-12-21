package pl.chaos.theory;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.chaos.theory.configuration.Profiles;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ChaosTheoryApplication.class)
@WebAppConfiguration
@ActiveProfiles(Profiles.TEST)
public abstract class BaseSpringTest {
}
