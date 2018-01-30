package pics.tomo.tomo.daos;

import org.springframework.data.repository.CrudRepository;
import pics.tomo.tomo.models.User;

public interface UsersRepository extends CrudRepository<User, Long> {

    User findByName(String name);
    User findById(long id);
}