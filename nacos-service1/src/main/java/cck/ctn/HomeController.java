package cck.ctn;

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
    @RequestMapping("/abc")
    public String test(){
        return "11";
    }
}
