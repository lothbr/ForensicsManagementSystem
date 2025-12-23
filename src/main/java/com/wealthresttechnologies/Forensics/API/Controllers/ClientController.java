package com.wealthresttechnologies.Forensics.API.Controllers;

import com.wealthresttechnologies.Forensics.Data.Entities.Clients;
import com.wealthresttechnologies.Forensics.Infrastructure.DTOs.AddClientDto;
import com.wealthresttechnologies.Forensics.Infrastructure.Services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Date;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/v1")
public class ClientController {
    @Autowired
    private BaseService baseService;
    private Logger logger = Logger.getLogger(ClientController.class.getName());

    @PostMapping("/AddClient")
    public String AddClient(AddClientDto clientDto){
        if (clientDto == null) return "missing body";

        // Convert secret to base64 Text
        Clients client = new Clients();
        client.setId("2187261721");
        client.setCreatedBy("System");
        client.setUsername(clientDto.Username);
        client.setSecret(clientDto.Secret);
        client.setDateCreated(new Date());

        // add Client to database
        try{
            baseService.clientService.saveClients(client);

        }
        catch (Exception ex){
            logger.info(ex.getMessage());

        }
        return "Record Added Successfully";
    }
}
