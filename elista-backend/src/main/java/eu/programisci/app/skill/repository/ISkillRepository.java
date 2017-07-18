package eu.programisci.app.skill.repository;


import eu.programisci.app.skill.ob.SkillOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillRepository extends JpaRepository<SkillOB,Long> {

}
