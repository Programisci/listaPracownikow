package eu.programisci.app.employee.repository;


import eu.programisci.app.employee.ob.EmployeeOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<EmployeeOB,Long> {

}
