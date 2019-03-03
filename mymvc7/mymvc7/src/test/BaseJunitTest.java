import example.controller.DemoController;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/applicationContext.xml","classpath*:/dispatcher-mvc.xml"})
public class BaseJunitTest {
    @Resource
    DemoController demoController;
}
