package food.delivery.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import food.delivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import food.delivery.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired NotificationRepository notificationRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Picked'")
    public void wheneverPicked_NotifyViaKakao(@Payload Picked picked){

        Picked event = picked;
        System.out.println("\n\n##### listener NotifyViaKakao : " + picked + "\n\n");


        

        // Sample Logic //
        Notification.notifyViaKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_NotifyViaKakao(@Payload DeliveryStarted deliveryStarted){

        DeliveryStarted event = deliveryStarted;
        System.out.println("\n\n##### listener NotifyViaKakao : " + deliveryStarted + "\n\n");


        

        // Sample Logic //
        Notification.notifyViaKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderFinshed'")
    public void wheneverOrderFinshed_NotifyViaKakao(@Payload OrderFinshed orderFinshed){

        OrderFinshed event = orderFinshed;
        System.out.println("\n\n##### listener NotifyViaKakao : " + orderFinshed + "\n\n");


        

        // Sample Logic //
        Notification.notifyViaKakao(event);
        

        

    }

}


