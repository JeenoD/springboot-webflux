package jeeno.demo.springbootwebflux.controller;

import jeeno.demo.springbootwebflux.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

/**
 * 控制层 （注解使用同于SpringMVC）
 * @author: Jeeno
 * @mail: jeenocruise@gmail.com
 * @date: 2019/7/5 15:42
 */
@Controller
public class MyController {

    @GetMapping("/annotation")
    @ResponseBody
    public Mono<String> index(){
        return Mono.just("get the response from server by annotation.");
    }

    @PostMapping("/annotation/login")
    @ResponseBody
    public Mono<User> login(User user){
        return Mono.just(user);
    }
}
