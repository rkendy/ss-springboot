package br.uff.ihs.ss.dto;

import java.time.LocalDateTime;

public class ErrorMsg {
    public final String msg;
    public final LocalDateTime timestamp;

    public ErrorMsg(String msg) {
        this.msg = msg;
        this.timestamp = LocalDateTime.now();

    }
}