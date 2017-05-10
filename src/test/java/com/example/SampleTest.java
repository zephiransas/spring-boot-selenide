package com.example;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleTest {

    @LocalServerPort
    int port;

    @Before
    public void setUp() throws Exception {
        Configuration.browser = WebDriverRunner.MARIONETTE;
        Configuration.baseUrl = "http://localhost:" + port;
    }

    @Test
    public void test() throws Exception {
        open("/");
        $("body").shouldHave(text("Hello!"));
    }

}
