package phint2.research.sentryspringbootroot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phint2.research.sentryspringbootroot.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
}
