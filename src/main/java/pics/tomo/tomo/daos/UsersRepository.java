package pics.tomo.tomo.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pics.tomo.tomo.models.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
    User findByName(String name);
    User findById(long id);
}