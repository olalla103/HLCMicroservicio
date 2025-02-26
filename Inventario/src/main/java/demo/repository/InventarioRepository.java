package demo.repository;

import demo.model.InventarioVO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventarioRepository extends MongoRepository<InventarioVO, String> {
}
