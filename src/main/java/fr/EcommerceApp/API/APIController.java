package fr.EcommerceApp.API;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")  // Autorise uniquement ce frontend
public class APIController {

    @GetMapping("/data")
    public String getData() {
        return "CORS activé !";
    }
}