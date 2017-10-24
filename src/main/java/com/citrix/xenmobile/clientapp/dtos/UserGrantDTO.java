package com.citrix.xenmobile.clientapp.dtos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGrantDTO {

    private Boolean userGrant;

    private QrResponseDTO qrResponseDTO;

    private UserDevice userDevice;

    private Long validUntil;

    public UserGrantDTO() {
    }

    public Boolean getUserGrant() {
        return userGrant;
    }

    public void setUserGrant(Boolean userGrant) {
        this.userGrant = userGrant;
    }

    public QrResponseDTO getQrResponseDTO() {
        return qrResponseDTO;
    }

    public void setQrResponseDTO(QrResponseDTO qrResponseDTO) {
        this.qrResponseDTO = qrResponseDTO;
    }

    public UserDevice getUserDevice() {
        return userDevice;
    }

    public void setUserDevice(UserDevice userDevice) {
        this.userDevice = userDevice;
    }

    public Long getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Long validUntil) {
        this.validUntil = validUntil;
    }
}
