package th.mfu;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position, String> {

    public List<Position> findAll();
}
