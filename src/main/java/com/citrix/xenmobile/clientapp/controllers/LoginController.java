package com.citrix.xenmobile.clientapp.controllers;

import com.citrix.xenmobile.clientapp.Constants;
import com.citrix.xenmobile.clientapp.dtos.QRCodeRequestDTO;
import com.citrix.xenmobile.clientapp.dtos.QrResponseDTO;
import com.citrix.xenmobile.clientapp.dtos.UserDevice;
import com.citrix.xenmobile.clientapp.dtos.UserGrantDTO;
import com.citrix.xenmobile.clientapp.services.FAPIService;
import com.citrix.xenmobile.clientapp.services.StringToImageService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Arrays;

@Controller
//@RequestMapping("/")
public class LoginController {

    @Value("${client.id}")
    private String clientID;

    @Value("${client.fqdn}")
    private String clientFQDN;

    @Autowired
    private FAPIService fapiService;

    @Autowired
    private StringToImageService stringToImageService;

    private HttpHeaders headers = new HttpHeaders();

    private QrResponseDTO qrResponseDTO;

    private UserDevice userDevice;

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam("username") String username, Model model) throws InterruptedException, IOException {
        System.out.println("Username retrieved : " + username);
        System.out.println("Client ID retrieved : " + clientID);

        //TimeUnit.SECONDS.sleep(2);
        if (username.isEmpty()) {
            model.addAttribute("error", "Error! Please enter a username");
            model.addAttribute("clientfqdn", clientFQDN);
            return "index";
        }

        QRCodeRequestDTO qrCodeRequestDTO = new QRCodeRequestDTO(username, clientID);

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<QRCodeRequestDTO> httpEntity = new HttpEntity<>(qrCodeRequestDTO, headers);

        ResponseEntity result = (ResponseEntity) fapiService.makeRestCall(Constants.CHECK_USERGRANT_URL, HttpMethod.POST, httpEntity);

        ObjectMapper objectMapper = new ObjectMapper();
        byte[] data = objectMapper.writeValueAsBytes(result.getBody());
        UserGrantDTO userGrantDTO = objectMapper.readValue(data, UserGrantDTO.class);

        Long currentTime = (System.currentTimeMillis() / 1000 );

        if(userGrantDTO.getUserGrant()){
            if (userGrantDTO.getValidUntil()> currentTime) {

                userDevice = userGrantDTO.getUserDevice();
                model.addAttribute("username", username);
                model.addAttribute("clientfqdn", clientFQDN);
                model.addAttribute("fullName", userDevice.getFullName());
                model.addAttribute("emailAddress", userDevice.getEmailAddress());
                model.addAttribute("phoneNumber", userDevice.getPhoneNumber());
                model.addAttribute("imei", userDevice.getImei());
                model.addAttribute("deviceName", userDevice.getDeviceName());
                model.addAttribute("deviceId", userDevice.getDeviceId());

                return "home";
            }else{

                userDevice = userGrantDTO.getUserDevice();
                model.addAttribute("username", username);
                model.addAttribute("clientfqdn", clientFQDN);
                model.addAttribute("fullName", userDevice.getFullName());
                model.addAttribute("emailAddress", userDevice.getEmailAddress());
                model.addAttribute("phoneNumber", userDevice.getPhoneNumber());
                model.addAttribute("imei", userDevice.getImei());
                model.addAttribute("deviceName", userDevice.getDeviceName());
                model.addAttribute("deviceId", userDevice.getDeviceId());

                return "intermediate";
            }

        } else {

            qrResponseDTO = userGrantDTO.getQrResponseDTO();
            System.out.println(qrResponseDTO.getQrCode());

            model.addAttribute("username", username);
            stringToImageService.setImageDataString(qrResponseDTO.getQrCode());
            model.addAttribute("qrcode", stringToImageService.getQrCodeFilePath());

            return "qrcode";
        }

    }

//    @RequestMapping(value="/checkstatus", method = RequestMethod.GET)
//    public String checkStatusForUser(@RequestParam("username") String username){
//
//        return "home";
//
//    }




}