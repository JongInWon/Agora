package com.agora.agora.config;

import com.agora.agora.repository.KakaoBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientFactory {
    @Value("${kakao.api.key}")
    private String apiKey;

    @Bean
    public KakaoBookRepository kakaoBookRepository() {
        RestClient client = RestClient.builder().baseUrl("https://dapi.kakao.com/")
                .defaultHeader("Authorization", "KakaoAK " + apiKey)
                .build();

        RestClientAdapter adapter = RestClientAdapter.create(client);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(KakaoBookRepository.class);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
