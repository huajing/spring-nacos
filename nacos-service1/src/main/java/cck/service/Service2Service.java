package cck.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "nacos-service2", fallback = MyFallback.class)
public interface Service2Service {
    @GetMapping("/abc")
    String test();
}
