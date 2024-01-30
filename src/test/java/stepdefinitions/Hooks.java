package stepdefinitions;

import helper.Utility;
import io.cucumber.java.*;

import java.util.Objects;

public class Hooks {
    String tagsRunning = null;

    @BeforeAll
    public static void setUp(){
        System.out.println("Before all test");
    }

    @AfterAll
    public static void tearDown(){
        System.out.println("After all test");
    }

    @Before
    public void berforeTest(Scenario scenario){
        System.out.println("Before test each scenario");
        Utility.startDriver();
    }

    @After
    public void afterTest(Scenario scenario) throws InterruptedException{
        System.out.println("After test each scenario");
        Utility.quitDriver();
    }
}
