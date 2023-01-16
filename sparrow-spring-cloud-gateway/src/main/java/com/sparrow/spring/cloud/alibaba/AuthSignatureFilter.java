package com.sparrow.spring.cloud.alibaba;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthSignatureFilter implements GlobalFilter, Ordered {

    public AuthSignatureFilter() {
        System.out.println("init");
    }

    static Logger logger = LoggerFactory.getLogger(AuthSignatureFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //logger.info("request = {}", JSONArray.toJSONString(exchange.getRequest()));
        String token = exchange.getRequest().getHeaders().getFirst("authToken");
        //验证token 合法性
        if (token == null || token.isEmpty()) { //如果token不合法，直接返回401
            //exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            //return exchange.getResponse().setComplete();
        }
        //向headers中放文件，记得build
        String userJson = "zhangsan";//todo from token
        ServerHttpRequest loginUser = exchange.getRequest().mutate().header("login-user", userJson).build();
        ServerWebExchange build = exchange.mutate().request(loginUser).build();
        return chain.filter(build);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}