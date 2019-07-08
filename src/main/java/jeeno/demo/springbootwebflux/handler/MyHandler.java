package jeeno.demo.springbootwebflux.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Optional;

/**
 * 请求处理函数（对应于@RequestMapping标注的方法）
 * @author: Jeeno
 * @mail: jeenocruise@gmail.com
 * @date: 2019/7/5 15:58
 */
public class MyHandler implements HandlerFunction<ServerResponse> {
    @Override
    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        return ServerResponse.ok().body(
                Mono.just("get the response from server by RouterFunction and HandlerFunction.\n"
                        + "the param server get :" + serverRequest.queryParam("param").get())
                , String.class);
    }
}
