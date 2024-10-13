package com.example.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, ItemDto> itemRedisTemplate (
        RedisConnectionFactory connectionFactory
    ) {
        RedisTemplate<String, ItemDto> template
                = new RedisTemplate<>();

        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(RedisSerializer.string()); // Key는 문자열로 직렬화, 역직렬화를 진행
        template.setValueSerializer(RedisSerializer.json());// Value는 데이터를 JSON으로 직렬화
        return template;

    }
}
