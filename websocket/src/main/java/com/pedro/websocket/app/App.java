package com.pedro.websocket.app;


import com.pedro.websocket.config.ObjetoMensagem;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
/**Esse código define um controlador WebSocket que pode ser usado para enviar mensagens para os clientes WebSocket conectados.
 * O método enviarMensagem() é mapeado para o destino de mensagem "/chatMessage".
 * Quando uma mensagem é recebida pelo destino de mensagem "/chatMessage", o método enviarMensagem() é chamado.
 * O método enviarMensagem() pega a mensagem do cliente e a envia para o destino de mensagem "/canal".
 * O destino de mensagem "/canal" é compartilhado por todos os clientes WebSocket conectados, portanto,
 * todos os clientes receberão a mensagem.
 */
@Controller //Aqui estamos indicando que a classe é um controlador responsavel por lidar com as solicitações do cliente
public class App {

    @MessageMapping("/chatMessage") //a anotação @MessageMapping("/chatMessage") diz ao Spring que o método enviarMensagem()
    // deve ser chamado quando uma mensagem for recebida pelo destino de mensagem "/chatMessage".
    @SendTo("/canal") //Essa anotação indica que a mensagem deve ser enviada para o destino de mensagem "/canal".
    // O destino de mensagem é usado para encaminhar a mensagem aos clientes WebSocket conectados.
    public ObjetoMensagem enviarMensagem(ObjetoMensagem mensagem){
        return mensagem;
    }
}
