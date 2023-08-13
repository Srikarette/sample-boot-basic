package th.mfu;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRespository respository;

    @Test
    public void testGetAllEmployees() {
        List<Employee> response = respository.findAll();

        assertEquals(10, response.size());
    }

}
