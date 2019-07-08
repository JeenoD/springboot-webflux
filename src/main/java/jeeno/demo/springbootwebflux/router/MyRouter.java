package jeeno.demo.springbootwebflux.router;

import jeeno.demo.springbootwebflux.handler.LoginHandler;
import jeeno.demo.springbootwebflux.handler.MyHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


/**
 * 路由映射函数（对应于@RequestMapping注解）
 * @author: Jeeno
 * @mail: jeenocruise@gmail.com
 * @date: 2019/7/5 16:01
 */
@Configuration
public class MyRouter {
    /**
     * map the url to the corresponding HandlerFunction
     * @return ServerResponse
     */
    @Bean
    public RouterFunction<ServerResponse> routerFunction() {

        return RouterFunctions.route(RequestPredicates.GET("/func"), new MyHandler())
                .filter((request, next) -> {
                    System.out.println("doing some filter operations.");
                    return next.handle(request);
                })
                .andRoute(
                        RequestPredicates.POST("/login").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)).and(RequestPredicates.contentType(MediaType.APPLICATION_FORM_URLENCODED))
                        , new LoginHandler());
    }
}
