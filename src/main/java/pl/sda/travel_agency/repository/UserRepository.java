package pl.sda.travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.travel_agency.model.User;
import pl.sda.travel_agency.model.enums.RoleEnum;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findFirstByEmail(String email);

    User findFirstByEmailAndPassword(String email, String password);

}
