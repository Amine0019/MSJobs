package tn.esprit.msjobs.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.msjobs.Entities.Jobs;
import tn.esprit.msjobs.Services.JobService;

import java.util.List;

@RestController
public class JobController {

    private String title = "Hello I am JobController";
    @RequestMapping("/helloJob")
    public String helloJob() {
        return title;
    }

    @Autowired
    private JobService jobService;
    @GetMapping
    public ResponseEntity<List<Jobs>> getAllJobs() {
        List<Jobs> candidats = jobService.getAll();
        if (candidats.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(candidats);
    }

}
