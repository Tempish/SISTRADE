package ac.cr.ucr.SISTRADE.repository;

import ac.cr.ucr.SISTRADE.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

}

