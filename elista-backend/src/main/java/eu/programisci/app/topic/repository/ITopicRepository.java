package eu.programisci.app.topic.repository;


import eu.programisci.app.topic.ob.TopicOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITopicRepository extends JpaRepository<TopicOB,Long> {

}
