package lk.spring.repo;

import lk.spring.entity.Rates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepo extends JpaRepository<Rates,String> {
}
