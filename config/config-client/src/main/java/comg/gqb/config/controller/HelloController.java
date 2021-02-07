package comg.gqb.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${info.master}")
    private String port;

    @RequestMapping("/port")
    public String getPort(){
        return port;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }


}
