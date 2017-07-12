package eu.programisci.app.employee.repository;


import eu.programisci.app.employee.dto.EmployeeLightDTO;
import eu.programisci.app.employee.ob.EmployeeOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<EmployeeOB,Long> {
    // Wiazanie po id rodzica. Relacja lezy po stronie rodzica.
    // Przyklad: GET /api/relacje/znajdzTelefonyPoIdKlienta?klientId=1
    @Query("SELECT t.contactValue " +
            " FROM EmployeeOB k " +
            " LEFT JOIN k.contact t " +
            " WHERE k.id = :employeeId ")
    List<String> findByIdContact(@Param("employeeId") Long aEmployeeId);
}
