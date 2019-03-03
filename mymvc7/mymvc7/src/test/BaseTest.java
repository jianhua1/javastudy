import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 单元测试基础类
 *
 * @author dingjunjie
 * @date 2018-01-28 17:02:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(locations={"classpath:spring/spring-mybatis.xml","classpath:spring/spring-mvc.xml"})
@ComponentScan(basePackages={"com.charlotte.blog.controller", "com.charlotte.sdk.main.service"})
//当然 你可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否
//@TransactionConfiguration( transactionManager = "transactionManager",defaultRollback = true)
//@Transactional
public class BaseTest {

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;

    protected MockHttpServletRequest request;
    protected MockHttpServletResponse response;

    /**
     * 初始化SpringmvcController类测试环境
     */
    @Before
    public void setup(){
        //加载web容器上下文
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

}