package eu.programisci.app.post.repository;


import eu.programisci.app.post.ob.PostOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<PostOB,Long> {

}
