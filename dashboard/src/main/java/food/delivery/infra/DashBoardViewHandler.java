package food.delivery.infra;

import food.delivery.domain.*;
import food.delivery.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DashBoardViewHandler {

    @Autowired
    private DashBoardRepository dashBoardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            DashBoard dashBoard = new DashBoard();
            // view 객체에 이벤트의 Value 를 set 함
            dashBoard.setMenuId(orderPlaced.getMenuId());
            dashBoard.setStoreId(orderPlaced.getStoreId());
            dashBoard.setStatus(orderPlaced.getStatus());
            dashBoard.setQty(orderPlaced.getQty());
            dashBoard.setUserId(orderPlaced.getUserId());
            dashBoard.setOrderId(String.valueOf(orderPlaced.getId()));
            // view 레파지 토리에 save
            dashBoardRepository.save(dashBoard);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenAccepted_then_UPDATE_1(@Payload Accepted accepted) {
        try {
            if (!accepted.validate()) return;
                // view 객체 조회

                List<DashBoard> dashBoardList = dashBoardRepository.findByOrderId(accepted.getOrderId());
                for(DashBoard dashBoard : dashBoardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashBoard.setStatus(accepted.getStatus());
                // view 레파지 토리에 save
                dashBoardRepository.save(dashBoard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenRejected_then_UPDATE_2(@Payload Rejected rejected) {
        try {
            if (!rejected.validate()) return;
                // view 객체 조회

                List<DashBoard> dashBoardList = dashBoardRepository.findByOrderId(rejected.getOrderId());
                for(DashBoard dashBoard : dashBoardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashBoard.setStatus(rejected.getStatus());
                // view 레파지 토리에 save
                dashBoardRepository.save(dashBoard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookStarted_then_UPDATE_3(@Payload CookStarted cookStarted) {
        try {
            if (!cookStarted.validate()) return;
                // view 객체 조회

                List<DashBoard> dashBoardList = dashBoardRepository.findByOrderId(cookStarted.getOrderId());
                for(DashBoard dashBoard : dashBoardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashBoard.setStatus(cookStarted.getStatus());
                // view 레파지 토리에 save
                dashBoardRepository.save(dashBoard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPicked_then_UPDATE_4(@Payload Picked picked) {
        try {
            if (!picked.validate()) return;
                // view 객체 조회

                List<DashBoard> dashBoardList = dashBoardRepository.findByOrderId(picked.getOrderId());
                for(DashBoard dashBoard : dashBoardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashBoard.setStatus(picked.getStatus());
                // view 레파지 토리에 save
                dashBoardRepository.save(dashBoard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_5(@Payload DeliveryStarted deliveryStarted) {
        try {
            if (!deliveryStarted.validate()) return;
                // view 객체 조회

                List<DashBoard> dashBoardList = dashBoardRepository.findByOrderId(deliveryStarted.getOrderId());
                for(DashBoard dashBoard : dashBoardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashBoard.setStatus(deliveryStarted.getStatus());
                // view 레파지 토리에 save
                dashBoardRepository.save(dashBoard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderFinshed_then_UPDATE_6(@Payload OrderFinshed orderFinshed) {
        try {
            if (!orderFinshed.validate()) return;
                // view 객체 조회

                List<DashBoard> dashBoardList = dashBoardRepository.findByOrderId(orderFinshed.getOrderId());
                for(DashBoard dashBoard : dashBoardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashBoard.setStatus(orderFinshed.getStatus());
                // view 레파지 토리에 save
                dashBoardRepository.save(dashBoard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void when_then_DELETE_(@Payload  ) {
        try {
            if (!.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            dashBoardRepository.deleteBy();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

