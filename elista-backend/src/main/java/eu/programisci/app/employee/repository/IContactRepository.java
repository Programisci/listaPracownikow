package eu.programisci.app.employee.repository;


import eu.programisci.app.employee.ob.ContactOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactRepository extends JpaRepository<ContactOB,Long> {

}
