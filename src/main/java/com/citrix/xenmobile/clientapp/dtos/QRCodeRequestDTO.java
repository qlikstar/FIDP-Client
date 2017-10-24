package com.citrix.xenmobile.clientapp.dtos;

public class QRCodeRequestDTO {

    private String username;

    private String clientId;

    public QRCodeRequestDTO() {
    }

    public QRCodeRequestDTO(String username, String clientId) {
        this.username = username;
        this.clientId = clientId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }


}
