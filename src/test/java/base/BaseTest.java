package base;

import junit.framework.TestResult;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.lang.reflect.Method;

@RunWith(JUnitPlatform.class)
@ExtendWith(BaseTestParameterResolver.class)
public class BaseTest implements BeforeEachCallback, AfterEachCallback {

    private static Logger logger = Logger.getLogger(BaseTest.class);
    private Logger regular = Logger.getLogger(getClass());
    private static final String START_TIME = "start time";

    @BeforeAll
    public static void beforeAll() {
        logger.info("Test start-------------------------------");
    }


    @AfterEach
    @Override
    public void afterEach(ExtensionContext context) {
        Method testMethod = context.getRequiredTestMethod();
        long startTime = getStore(context).remove(START_TIME, long.class);
        long duration = System.currentTimeMillis() - startTime;
        regular.info(
                String.format("Method [%s] took %s ms.", testMethod.getName(), duration));
    }

    @BeforeEach
    @Override
    public void beforeEach(ExtensionContext context) {
        getStore(context).put(START_TIME, System.currentTimeMillis());
    }

    private Store getStore(ExtensionContext context) {
        return context.getStore(ExtensionContext.Namespace.create(getClass(), context.getRequiredTestMethod()));
    }

    @AfterAll
    public static void afterAll(TestResult result) {
//        logger.info("Test Runs:" + result.runCount());
//        logger.info("Test Fails:" + result.failureCount());
//        logger.info("Error Count:" + result.errorCount());
        logger.info("Test end-------------------------------");
    }
}

