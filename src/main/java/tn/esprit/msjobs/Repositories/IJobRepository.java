package tn.esprit.msjobs.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.msjobs.Entities.Jobs;

public interface IJobRepository extends JpaRepository <Jobs, Integer> {
}
