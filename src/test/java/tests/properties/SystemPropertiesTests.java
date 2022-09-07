package tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    void simplePropertyTest() {
        String browserName = System.getProperty("browser");
        System.out.println(browserName); // null
    }

    @Test
    void simplePropertyTest1() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser");
        System.out.println(browserName); // opera
    }

    @Test
    void simplePropertyTest2() {
        String browserName = System.getProperty("browser","firefox");
        System.out.println(browserName); // firefox
    }

    @Test
    void simplePropertyTest3() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser","firefox");
        System.out.println(browserName); // opera
    }

    @Test
    @Tag("properties")
    void simplePropertyTest4() {
        String browserName = System.getProperty("browser_name","firefox");
        String browserVersion = System.getProperty("browser_version","101");
        String browserSize = System.getProperty("browser_size","1500x800");

        System.out.println(browserName);
        System.out.println(browserVersion);
        System.out.println(browserSize);

        /*
        From IDEA
            firefox
            101
            1500x800

        gradle clean properties_test
            firefox
            101
            1500x800

        gradle clean properties_test -Dbrowser_name=safari
            safari
            101
            1500x800

        gradle clean properties_test -Dbrowser_name=safari -Dbrowser_version=101 -Dbrowser_size=300x300
            safari
            101
            300x300
         */
    }

    @Test
    @Tag("hello")
    void simplePropertyTest5() {
        System.out.println("Hello, " + System.getProperty("some_text","qa.guru"));

        /*
        gradle clean hello_test
            Hello, qa.guru

        gradle clean hello_test -Dsome_text=lessons
            Hello, lessons

        gradle clean hello_test -Dsome_text="lessons 11"
            Hello, lessons 11

        gradle clean hello_test -Dsome_text=students of qa.guru
            FAILURE: Build failed with an exception.

            * What went wrong:
            Task 'of' not found in root project 'work-11-jenkins'.

        gradle clean hello_test "-Dsome_text=students of qa.guru"
            Hello, students of qa.guru
         */
    }
}
