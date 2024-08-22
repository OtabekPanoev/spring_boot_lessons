package uz.pdp.spring_boot_lessons;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Component
@ConfigurationProperties(prefix = "cache")
public class CacheConfigProperties {
    private int redisPort = 16379;
    private long timeoutSeconds = 60;
    private String redisHost = "localhost";
    private String redisPassword = "redis";
    private int redisTimeoutSeconds = 2;
    private int redisSocketTimeoutSeconds = 2;
    private Map<String, Long> cacheExpirations = new HashMap<>();

    public CacheConfigProperties setRedisPort(int redisPort) {
        this.redisPort = redisPort;
        return this;
    }

    public CacheConfigProperties setTimeoutSeconds(long timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
        return this;
    }

    public CacheConfigProperties setRedisHost(String redisHost) {
        this.redisHost = redisHost;
        return this;
    }

    public CacheConfigProperties setRedisPassword(String redisPassword) {
        this.redisPassword = redisPassword;
        return this;
    }

    public CacheConfigProperties setCacheExpirations(Map<String, Long> cacheExpirations) {
        this.cacheExpirations = cacheExpirations;
        return this;
    }

    public CacheConfigProperties setRedisTimeoutSeconds(int redisTimeoutSeconds) {
        this.redisTimeoutSeconds = redisTimeoutSeconds;
        return this;
    }

    public CacheConfigProperties setRedisSocketTimeoutSeconds(int redisSocketTimeoutSeconds) {
        this.redisSocketTimeoutSeconds = redisSocketTimeoutSeconds;
        return this;
    }
}
