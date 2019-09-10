package base;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.lang.reflect.Method;

@RunWith(JUnitPlatform.class)
@ExtendWith(BaseTestParameterResolver.class)
public class BaseTest implements BeforeEachCallback, AfterEachCallback {

    final static Logger logger = Logger.getLogger(BaseTest.class);
    private static final String START_TIME = "start time";
    private BaseTestParameterResolver baseTestParameterResolver = new BaseTestParameterResolver();
    private ParameterContext parameterContext;
    @BeforeAll
    public static void beforeAll() {
        logger.info("Test start-------------------------------");
    }
//    private Store getStore (ExtensionContext context){
//        return context.getStore(Namespace.create(getClass(), context.getRequiredTestMethod()));
//    }

    @AfterAll
    public static void afterAll(){
        logger.info("Test end-------------------------------");
    }
    @AfterEach
    @Override
    public void afterEach(ExtensionContext context) {
        Method testMethod = context.getRequiredTestMethod();
        //long startTime = getStore(context).remove(START_TIME, long.class);
        long startTime = baseTestParameterResolver.resolveParameter(parameterContext, context).remove(START_TIME, long.class);
        long duration = System.currentTimeMillis() - startTime;

        logger.info(
                String.format("Method [%s] took %s ms.", testMethod.getName(), duration));


    }
    @BeforeEach
    @Override
    public void beforeEach(ExtensionContext context){
        baseTestParameterResolver.resolveParameter(parameterContext, context).put(START_TIME, System.currentTimeMillis());
    }
}

