package com.pedro.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
/**
Esse código configura um broker de mensagens simples com um destino de aplicação chamado "/app". O endpoint WebSocket "conect" está registrado para esse destino.
O endpoint WebSocket "conect" permite que os clientes WebSocket se conectem ao servidor usando o protocolo STOMP ou o protocolo SockJS.
*/
@Configuration /*Usamos a anotação "@Configuration" para informar ao Spring que isso é uma classe de configuração
Ela é necessária para que o Spring possa encontrar e carregar a classe.*/
@EnableWebSocketMessageBroker /*Usamos essa anotação para ativar os recursos do WebSocket. Ela também configura o
broker de mensagens, que é responsável por encaminhar as mensagens entre os clientes WebSocket e o servidor. */
public class WebSocket implements WebSocketMessageBrokerConfigurer {
    /* Nossa classe implementa a interface de Configuração do MessageBroker do WebSocket
    * Por ser uma interface, podemos então sobrescrever alguns métodos para configurar da nossa maneira*/

    @Override //Estamos aqui sobrescrevendo o método de configurar o Message broker
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/canal");
        /*Aqui estamos habilitando o broker de mensagem simples. O broker de mensagens simples é um broker de
        mensagens de texto que suporta o protocolo STOMP.*/
        registry.setApplicationDestinationPrefixes("/app");
        /*Essa linha define o prefixo das URLs que representam destinos de aplicação.
        Os destinos de aplicação são usados para encaminhar mensagens entre os clientes WebSocket e o servidor.
        * */
    }

    @Override //Aqui estamos sobrescrevendo o método de registrar os endpoints WebSocket
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("conect").setAllowedOrigins("*");
        /*Aqui estamos registrando (criando) o endpoint WebSocket "conect"
        * Com esse endpoint, os cliente WebSocket conseguem se conectar ao servidor (Nossa aplicação Java aqui) */
        registry.addEndpoint("conect").withSockJS();
        /*Aqui é só por convenção caso o navegador não suporte o websocket diretamente.
        * */
    }
}
