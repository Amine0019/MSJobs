package tn.esprit.msjobs.Services;

import tn.esprit.msjobs.Entities.Jobs;

import java.util.List;

public interface IJobService {
    public List<Jobs> getAll();
    public Jobs addJob(Jobs job);
    public Jobs updateJob(int id, Jobs newJob);
    public String deleteJob(int id);
}
