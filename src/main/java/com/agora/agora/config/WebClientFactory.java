package com.agora.agora.config;

import com.agora.agora.repository.KakaoBookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientFactory {

    @Bean
    public KakaoBookRepository WebClient() {
        WebClient client = WebClient.builder().baseUrl("https://dapi.kakao.com/")
                .defaultHeader("Authorization", "KakaoAK e3c02de16b1c97114fec582fddbde0b3")
                .build();

        WebClientAdapter adapter = WebClientAdapter.create(client);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(KakaoBookRepository.class);
    }
}
