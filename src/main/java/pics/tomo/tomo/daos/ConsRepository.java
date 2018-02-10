package pics.tomo.tomo.daos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pics.tomo.tomo.models.Con;
import pics.tomo.tomo.models.User;

import java.util.List;

@Repository
public interface ConsRepository extends CrudRepository<Con, Long> {

//    @Query(nativeQuery = true,
//            value = "SELECT * from cons c JOIN users u ON c.user_id = u.id WHERE u.id LIKE ?1")
    List<Con> findAllById(long id);

}