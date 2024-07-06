package com.agora.agora.config;

import com.agora.agora.repository.KakaoBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientFactory {
    @Value("${kakao.api.key}")
    private String apiKey;

    @Bean
    public KakaoBookRepository kakaoBookRepository() {
        WebClient client = WebClient.builder().baseUrl("https://dapi.kakao.com/")
                .defaultHeader("Authorization", "KakaoAK " + apiKey)
                .build();

        WebClientAdapter adapter = WebClientAdapter.create(client);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(KakaoBookRepository.class);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
