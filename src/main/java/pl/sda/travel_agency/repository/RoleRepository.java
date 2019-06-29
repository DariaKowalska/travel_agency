package pl.sda.travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.travel_agency.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
