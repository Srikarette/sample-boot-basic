package th.mfu;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface EmployeeRespository extends CrudRepository<Employee, Long> {
    public List<Employee> findAll();

    public List<Employee> findByfname(String firstName);

    public List<Employee> findByfnameStartingWith(String prefix);
}
