package com.wealthresttechnologies.Forensics.API.Controllers;

//import com.wealthresttechnologies.Forensics.API.Managers.BaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class AuthController {
//    @Autowired
//    private BaseManager _baseManager;
    @GetMapping("/token")
    public String GetAuthToken(){
        return "Okay here";
    }
}
