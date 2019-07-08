package jeeno.demo.springbootwebflux.handler;

import jeeno.demo.springbootwebflux.pojo.User;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Optional;

/**
 * @author: Jeeno
 * @mail: jeenocruise@gmail.com
 * @date: 2019/7/5 17:40
 */
public class LoginHandler implements HandlerFunction<ServerResponse> {
    @Override
    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        Mono<MultiValueMap<String, String>> params = serverRequest.formData();
        return params.flatMap(map -> {
            // username
//            System.out.println(map.get("username").get(0));
            // password
//            System.out.println(map.get("password").get(0));
            if ("username".equals(map.get("username").get(0))){
                return ServerResponse.ok()
                        .body(Mono.just("login succeed."), String.class);
            }
            return ServerResponse.ok()
                    .body(Mono.just("login failed"), String.class);
        });
    }
}
