package com.market.order;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderApplicationQueueConfig {

    @Value("${message.exchange}")
    private String exchange; // market

    @Value("${message.queue.product}")
    private String queueProduct; // 큐1 (market.product), 바인딩 이름은 큐의 이름과 일치시킴

    @Value("${message.queue.payment}")
    private String queuePayment; // 큐2 (market.payment)

    @Bean public TopicExchange exchange() { return new TopicExchange(exchange); } // 익스체인지 생성함수

    @Bean public Queue queueProduct() { return new Queue(queueProduct); } // 큐1 생성함수
    @Bean public Queue queuePayment() { return new Queue(queuePayment); } // 큐2 생성함수

    @Bean public Binding bindingProduct() { return BindingBuilder.bind(queueProduct()).to(exchange()).with(queueProduct); }
    @Bean public Binding bindingPayment() { return BindingBuilder.bind(queuePayment()).to(exchange()).with(queuePayment); }
    // 바인딩의 이름은 큐의 이름과 일치키셔야 되어서 마지막 with 안에 exchange가 들어가는 게 아니라
    // 각각 큐의 이름인 queueProduct, queuePayment가 들어감
}
