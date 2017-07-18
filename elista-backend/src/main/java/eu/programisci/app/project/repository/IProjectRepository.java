package eu.programisci.app.project.repository;


import eu.programisci.app.project.ob.ProjectOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends JpaRepository<ProjectOB,Long> {

}
