package com.example.webflux.handler;

import com.example.webflux.data.Notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Service
public class NotificationHandler {

    private static Logger logger = LoggerFactory.getLogger(NotificationHandler.class);

    public Mono<ServerResponse> postNotification(ServerRequest request) {
        Integer id;

        try {
            id = Integer.valueOf(request.pathVariable("id"));
        } catch (NumberFormatException ex) {
            return ServerResponse.status(HttpStatus.BAD_REQUEST.value()).build();
        }

        logger.info("post notification: " + id);
        Mono<Notification> notificationMono = Mono.just(new Notification(id));
        return ServerResponse.ok().body(notificationMono, Notification.class);
    }
}
