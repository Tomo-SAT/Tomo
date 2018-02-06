package pics.tomo.tomo.daos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pics.tomo.tomo.models.Con;
import pics.tomo.tomo.models.User;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
    User findByName(String name);
    User findById(long id);
    List<User> findAll();

@Query(nativeQuery = true, value="SELECT * FROM users WHERE name LIKE ?1")
    List<User> search(String q);

//what if we want to search from multiple tables?





}