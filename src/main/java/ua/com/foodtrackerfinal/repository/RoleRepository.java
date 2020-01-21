package ua.com.foodtrackerfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.foodtrackerfinal.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
