package com.example;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleTest {

    @LocalServerPort
    int port;

    @Autowired
    EmployeeRepository employeeRepository;

    @Before
    public void setUp() throws Exception {
        Configuration.browser = WebDriverRunner.MARIONETTE;
        Configuration.baseUrl = "http://localhost:" + port;
    }

    @Test
    @Transactional
    public void test() throws Exception {
        Employee e = Employee.builder()
                .name("sample")
                .email("sample@example.com")
                .build();
        employeeRepository.save(e);

        open("/");
        $("body").shouldHave(text("sample@example.com"));
    }

}
