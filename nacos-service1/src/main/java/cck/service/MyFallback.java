package cck.service;

import org.springframework.stereotype.Component;


@Component
public class MyFallback implements Service2Service {
    @Override
    public String test() {
        return "error";
    }
}
