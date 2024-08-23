package uz.pdp.spring_boot_lessons;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Cacheable(value = "hello1", key = "#id")
    @GetMapping("/hello1/{id}")
    public String hello1(@PathVariable Integer id) {
        System.out.println("--------Cash hello1---------");
        return "Hello1 " + id;
    }

    @Cacheable(value = "hello2", key = "#id")
    @GetMapping("/hello2/{id}")
    public String hello2(@PathVariable Integer id) {
        System.out.println("--------Cash hello2---------");
        return "Hello1 " + id;
    }

    @Cacheable(value = "hello3", key = "#id")
    @GetMapping("/hello3/{id}")
    public BeltLogRes hello3(@PathVariable Integer id) {
        System.out.println("--------Cash hello3---------");

        return new BeltLogRes();
    }
}
