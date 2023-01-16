package food.delivery.infra;

import food.delivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="dashBoards", path="dashBoards")
public interface DashBoardRepository extends PagingAndSortingRepository<DashBoard, Long> {

    List<DashBoard> findByOrderId(String orderId);


    
}
