package com.example.webflux;

import com.example.webflux.handler.NotificationHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RoutingConfiguration {

    @Bean
    public RouterFunction<ServerResponse> getRoute(NotificationHandler notificationHandler) {
        return route(GET("/notification/{id}").and(accept(MediaType.APPLICATION_JSON)), notificationHandler::postNotification);
    }
}
