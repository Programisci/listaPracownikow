package eu.programisci.app.topic.ob;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "topic")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_topic_id")
public class TopicOB {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;

    @Column(name = "message")
    private String message;


    @Column(name = "employeeId")
    private Long employeeId;


    @Column(name = "creation_date", columnDefinition = "TIMESTAMP")
    private Date creationDate;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "employee_id")
//    private EmployeeOB employeee;

}
