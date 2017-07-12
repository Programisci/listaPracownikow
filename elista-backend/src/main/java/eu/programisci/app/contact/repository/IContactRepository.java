package eu.programisci.app.contact.repository;


import eu.programisci.app.contact.ob.ContactOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactRepository extends JpaRepository<ContactOB,Long> {



}
