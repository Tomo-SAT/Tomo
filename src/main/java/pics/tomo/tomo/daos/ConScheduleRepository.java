package pics.tomo.tomo.daos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pics.tomo.tomo.models.Con;
import pics.tomo.tomo.models.ConSchedule;

import java.util.List;

public interface ConScheduleRepository extends CrudRepository<ConSchedule, Long>{
//    @Query(nativeQuery = true,
////            value = "SELECT * from con_schedule c JOIN users u ON c.creator_id = u.id WHERE c.creator_id LIKE ?1")
//            value = "SELECT time from con_schedule cs WHERE creator_id LIKE ?1 AND con_id = 1")
    List<ConSchedule> findAllByCreatorId(long id);

    @Query(nativeQuery = true,
            value = "SELECT * from con_schedule cs WHERE creator_id LIKE ?1 AND con_id = 1")

    List<ConSchedule> usersTimeByConId(long user_id);

}
