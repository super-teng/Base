package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springboot.po.Girl;

import javax.validation.Valid;

/**
 * Created by Super腾 on 2017/1/12.
 */
@RestController
public class UrlController {

    @Value("${girl.cupSize}")
    private String cupSize;
    @Value("${girl.age}")
    private Integer age;
    @Autowired
    private Girl girl;
    @GetMapping("/hello")
    public String hello(){
        return "hello spring boot";
    }
    @RequestMapping("/information/{name}/{age}")
    public String baseInformation(@PathVariable String name,@PathVariable Integer age){
        return " information: name : "+name+" age:"+age;
    }
    @RequestMapping("/request")
    public String requestInformation(@RequestParam String name,@RequestParam Integer age){
        return "name: "+name+" age: "+age;
    }
    @RequestMapping("/girl")
    public String girlInformation(){
        return "cupSize: "+cupSize+" age:"+age;
    }
    @RequestMapping("/girlUp")
    public String girlInformationUp(){
        return "cupSize: "+girl.getCupSize()+" age: "+girl.getAge();
    }
}
