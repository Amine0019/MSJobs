package tn.esprit.msjobs.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.msjobs.Entities.Jobs;
import tn.esprit.msjobs.Repositories.IJobRepository;

import java.util.List;

@Service
public class JobService implements IJobService {

    @Autowired
    private IJobRepository jobRepository;

    @Override
    public List<Jobs> getAll() {
        return jobRepository.findAll();
    }

    @Override
    public Jobs addJob(Jobs job) {
        return jobRepository.save(job);
    }

    @Override
    public Jobs updateJob(int id, Jobs newJob) {
        if (jobRepository.findById(id).isPresent()) {

            Jobs existingJob = jobRepository.findById(id).get();
            existingJob.setService(newJob.getService());
            existingJob.setEtat(newJob.isEtat());

            return jobRepository.save(existingJob);
        } else
            return null;
    }

    @Override
    public String deleteJob(int id) {
        if (jobRepository.findById(id).isPresent()) {
            jobRepository.deleteById(id);
            return "Job supprimé";
        } else
            return "Job non supprimé";
    }

}
