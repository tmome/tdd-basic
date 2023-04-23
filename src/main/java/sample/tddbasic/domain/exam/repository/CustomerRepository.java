package sample.tddbasic.domain.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.tddbasic.domain.exam.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
