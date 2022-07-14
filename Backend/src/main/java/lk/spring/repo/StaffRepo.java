package lk.spring.repo;

import lk.spring.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepo extends JpaRepository<Admin,String> {
}
