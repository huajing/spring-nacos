package cck.ctn;

import cck.service.Service2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title cck.ctn
 * @Copyright: Copyright 2021
 * @Description: java <br/>
 * @Created on 2021/4/18 chenck
 */
@RestController
public class HomeController {
    @Autowired
    private Service2Service service2Service;

    @RequestMapping("/abc")
    public String test(){
        return service2Service.test();
    }
}
