package com.sport.bet.web.test.base;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sport.bet.web.Application;

@RunWith(SpringRunner.class) //14.版本之前用的是SpringJUnit4ClassRunner.class
@SpringBootTest(classes = Application.class) //1.4版本之前用的是//@SpringApplicationConfiguration(classes = Application.class)
public class BaseTest {

}
