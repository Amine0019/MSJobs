package tn.esprit.msjobs.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

    private String title = "Hello I am JobController";
    @RequestMapping("/helloJob")
    public String helloJob() {
        return title;
    }

}
