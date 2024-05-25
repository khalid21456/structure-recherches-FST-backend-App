package com.PFE.StructureRechercheFST.Config;

import lombok.NoArgsConstructor;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.core5.util.Timeout;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.client.config.RequestConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@SuppressWarnings("unused")
@NoArgsConstructor
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Value("${resttemplate.connection.timeout}")
    private int connectionTimeout;

    @Value("${resttemplate.read.timeout}")
    private int readTimeout;



    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("DELETE","POST","GET","PUT")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }
}
