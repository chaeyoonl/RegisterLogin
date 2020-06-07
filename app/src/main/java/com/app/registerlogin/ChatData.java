package com.app.registerlogin;

import java.io.Serializable;

public class ChatData implements Serializable {
    private String msg;
    private String msg2;
    private String nickname;


    public String getMsg() {
        return msg;
    }



    public void setMsg(String msg) {
        this.msg = msg;
        this.msg2 = msg2;
    }



    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
