package tn.esprit.msjobs.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.msjobs.Entities.Jobs;
import tn.esprit.msjobs.Services.JobService;

import java.util.List;

@RestController
@RequestMapping("/Jobs")
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Jobs> createJob(@RequestBody Jobs job) {
        return new ResponseEntity<>(jobService.addJob(job), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Jobs> updateJob(@PathVariable("id") int id,
                                                   @RequestBody Jobs job) {
        return ResponseEntity.ok(jobService.updateJob(id, job));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable("id") int id){
        return new ResponseEntity<>(jobService.deleteJob(id), HttpStatus.OK);
    }

}
