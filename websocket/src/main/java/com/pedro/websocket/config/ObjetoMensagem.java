package com.pedro.websocket.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjetoMensagem {
    private String user;
    private String msg;
}
