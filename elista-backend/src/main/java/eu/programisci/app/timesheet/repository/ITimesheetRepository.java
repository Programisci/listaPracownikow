package eu.programisci.app.timesheet.repository;


import eu.programisci.app.timesheet.ob.TimesheetOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITimesheetRepository extends JpaRepository<TimesheetOB,Long> {

}
