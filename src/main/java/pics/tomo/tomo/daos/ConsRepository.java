package pics.tomo.tomo.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pics.tomo.tomo.models.Con;

@Repository
public interface ConsRepository extends CrudRepository<Con, Long> {
    Con findById(long id);

}