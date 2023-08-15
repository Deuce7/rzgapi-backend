package com.rzg;


import com.rzg.client.RzgApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("rzgapi.client")
@Data
@ComponentScan
public class RzgApiClientConfig {
    private String accessKey;
    private String secretKey;

    @Bean
    public RzgApiClient RzgApiClient(){
        return new RzgApiClient(accessKey, secretKey);
    }
}
