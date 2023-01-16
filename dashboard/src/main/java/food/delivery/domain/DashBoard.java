package food.delivery.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="DashBoard_table")
@Data
public class DashBoard {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String orderId;
        private String menuId;
        private String address;
        private String status;
        private String storeId;
        private String qty;
        private String userId;


}
