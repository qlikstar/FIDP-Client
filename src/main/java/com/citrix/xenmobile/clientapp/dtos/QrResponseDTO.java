package com.citrix.xenmobile.clientapp.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//QrResponseDTO{qrCode='hgdwqgdwqhdqwjdjjjwqhj',
// androidAppDownloadLink='null',
// iosAppDownloadLink='null',
// googlePlayDownloadButtonImg='null',
// appstoreDownloadButtonImg='null'}

@JsonIgnoreProperties(ignoreUnknown = true)
public class QrResponseDTO {

    private String qrCode;

    private String androidAppDownloadLink;

    private String iosAppDownloadLink;

    private String googlePlayDownloadButtonImg;

    private String appstoreDownloadButtonImg;

    public QrResponseDTO() {
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getAndroidAppDownloadLink() {
        return androidAppDownloadLink;
    }

    public void setAndroidAppDownloadLink(String androidAppDownloadLink) {
        this.androidAppDownloadLink = androidAppDownloadLink;
    }

    public String getIosAppDownloadLink() {
        return iosAppDownloadLink;
    }

    public void setIosAppDownloadLink(String iosAppDownloadLink) {
        this.iosAppDownloadLink = iosAppDownloadLink;
    }

    public String getGooglePlayDownloadButtonImg() {
        return googlePlayDownloadButtonImg;
    }

    public void setGooglePlayDownloadButtonImg(String googlePlayDownloadButtonImg) {
        this.googlePlayDownloadButtonImg = googlePlayDownloadButtonImg;
    }

    public String getAppstoreDownloadButtonImg() {
        return appstoreDownloadButtonImg;
    }

    public void setAppstoreDownloadButtonImg(String appstoreDownloadButtonImg) {
        this.appstoreDownloadButtonImg = appstoreDownloadButtonImg;
    }


}
