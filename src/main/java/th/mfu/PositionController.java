package th.mfu;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionController {
    @Autowired
    private PositionRepository positionRepository;

    @PostMapping("/positions")
    public ResponseEntity createPosition(@RequestBody Position position) {
        positionRepository.save(position);
        return ResponseEntity.ok(position);
    }

    @GetMapping("/positions")
    public Collection<Position> getAllEmployees() {
        return positionRepository.findAll();
    }
}
