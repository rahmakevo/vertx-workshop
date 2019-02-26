package com.mycompany.vertx_micro_services;
/*
 * Copyright 2013 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */

import io.vertx.ext.web.Router;
import org.vertx.java.core.Future;
import org.vertx.java.core.Handler;
import org.vertx.java.core.Vertx;
import org.vertx.java.core.eventbus.Message;
import org.vertx.java.core.http.HttpServer;
import org.vertx.java.core.http.HttpServerResponse;
import org.vertx.java.platform.Verticle;

/*
This is a simple Java verticle which receives `ping` messages on the event bus and sends back `pong` replies
 */
public class PingVerticle extends Verticle {

  public void start(Future<Void> fut) {
//    vertx.eventBus().registerHandler("ping-address", new Handler<Message<String>>() {
//      @Override
//      public void handle(Message<String> message) {
//        message.reply("pong!");
//        container.logger().info("Sent back pong");
//      }
//    });
//
//    container.logger().info("PingVerticle started");

    HttpServer server = vertx.createHttpServer();

    Router router = Router.router(vertx);

    router.route().handler(routingContext -> {
      HttpServerResponse response = routingContext.response();
      response.putHeader("content-type", "text/plain");
      response.end("Hello Word from Vert.x-Web!");
    });

    server.requestHandler(router).listen(8080);

  }
}
