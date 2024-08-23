package uz.pdp.spring_boot_lessons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

public class RedisCacheErrorHandler implements CacheErrorHandler {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void handleCacheGetError(RuntimeException e, Cache cache, Object o) {
        handleTimeoutException(e);
    }

    @Override
    public void handleCachePutError(RuntimeException e, Cache cache, Object o, Object o1) {
        handleTimeoutException(e);
    }

    @Override
    public void handleCacheEvictError(RuntimeException e, Cache cache, Object o) {
        handleTimeoutException(e);
    }

    @Override
    public void handleCacheClearError(RuntimeException e, Cache cache) {
        handleTimeoutException(e);
    }

    private void handleTimeoutException(RuntimeException exception) {
        logger.error(exception.getMessage());
    }
}
