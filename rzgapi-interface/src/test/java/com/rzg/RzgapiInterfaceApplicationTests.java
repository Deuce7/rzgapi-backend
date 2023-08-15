package com.rzg;

import com.rzg.client.RzgApiClient;
import com.rzg.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class RzgapiInterfaceApplicationTests {

    @Resource
    private RzgApiClient rzgApiClient;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("Rzg");

        String result = rzgApiClient.getNameByPost(user);
        System.out.println(result);
    }

}
