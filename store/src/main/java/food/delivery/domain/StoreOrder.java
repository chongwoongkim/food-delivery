package food.delivery.domain;

import food.delivery.domain.CookStarted;
import food.delivery.domain.CookFinshed;
import food.delivery.domain.Accepted;
import food.delivery.domain.Rejected;
import food.delivery.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="StoreOrder_table")
@Data

public class StoreOrder  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String storeId;
    
    
    
    
    
    private String menuId;
    
    
    
    
    
    private String qty;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();



        CookFinshed cookFinshed = new CookFinshed(this);
        cookFinshed.publishAfterCommit();

    }
    @PostUpdate
    public void onPostUpdate(){


        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();



        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();

    }
    @PreUpdate
    public void onPreUpdate(){
    }

    public static StoreOrderRepository repository(){
        StoreOrderRepository storeOrderRepository = StoreApplication.applicationContext.getBean(StoreOrderRepository.class);
        return storeOrderRepository;
    }




    public static void orderInfoTransfer(OrderPlaced orderPlaced){

        /** Example 1:  new item 
        StoreOrder storeOrder = new StoreOrder();
        repository().save(storeOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(storeOrder->{
            
            storeOrder // do something
            repository().save(storeOrder);


         });
        */

        
    }
    public static void cancelCook(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        StoreOrder storeOrder = new StoreOrder();
        repository().save(storeOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(storeOrder->{
            
            storeOrder // do something
            repository().save(storeOrder);


         });
        */

        
    }


}
