package uz.pdp.spring_boot_lessons;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.SocketOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(CacheConfigProperties.class)
public class CacheConfig implements CachingConfigurer {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory(CacheConfigProperties cacheConfigProperties) {
        SocketOptions socketOptions = SocketOptions.builder()
                .connectTimeout(Duration.ofSeconds(cacheConfigProperties.getRedisSocketTimeoutSeconds()))
                .build();
        ClientOptions clientOptions = ClientOptions.builder()
                .socketOptions(socketOptions)
                .build();
        LettuceClientConfiguration clientConfiguration = LettuceClientConfiguration.builder()
                .commandTimeout(Duration.ofSeconds(cacheConfigProperties.getRedisTimeoutSeconds()))
                .clientOptions(clientOptions)
                .build();

        RedisStandaloneConfiguration standaloneConfiguration = new RedisStandaloneConfiguration();
        standaloneConfiguration.setHostName(cacheConfigProperties.getRedisHost());
        standaloneConfiguration.setPort(cacheConfigProperties.getRedisPort());
        standaloneConfiguration.setPassword(cacheConfigProperties.getRedisPassword());
        return new LettuceConnectionFactory(standaloneConfiguration, clientConfiguration);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory rcf) {
        RedisSerializer<Object> genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(genericJackson2JsonRedisSerializer);
        redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);
        redisTemplate.setConnectionFactory(rcf);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    private static RedisCacheConfiguration createCacheConfig(long timeoutSeconds) {
        return RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(timeoutSeconds));
    }

    @Bean
    public RedisCacheConfiguration redisCacheConfiguration(CacheConfigProperties cacheConfigProperties) {
        return createCacheConfig(cacheConfigProperties.getTimeoutSeconds());
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory, CacheConfigProperties cacheConfigProperties) {
        Map<String, RedisCacheConfiguration> cacheConfigurationMap = new HashMap<>();
        Map<String, Long> specificCacheExpirations = new HashMap<>();
        specificCacheExpirations.put("panEncrypt", -1L);
        specificCacheExpirations.put("panDecrypt", -1L);
        specificCacheExpirations.putAll(CacheNames.EXPIRATIONS);

        cacheConfigProperties.setCacheExpirations(specificCacheExpirations);

        for (Map.Entry<String, Long> cacheNameAndTimeout : cacheConfigProperties.getCacheExpirations().entrySet()) {
            cacheConfigurationMap.put(cacheNameAndTimeout.getKey(), createCacheConfig(cacheNameAndTimeout.getValue()));
        }
        return RedisCacheManager
                .builder(redisConnectionFactory)
                .cacheDefaults(redisCacheConfiguration(cacheConfigProperties))
                .withInitialCacheConfigurations(cacheConfigurationMap)
                .build();
    }


    @Override
    public CacheErrorHandler errorHandler() {
        return new RedisCacheErrorHandler();
    }

}
