
package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping(value = "/vvv",method = RequestMethod.GET)
    public String index() {
        System.out.println("--11------22223----");
        System.out.println("++++++++++++++++");
        return "index";
    }
}