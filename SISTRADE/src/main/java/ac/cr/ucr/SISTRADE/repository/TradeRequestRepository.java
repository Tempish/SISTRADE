package ac.cr.ucr.SISTRADE.repository;


import ac.cr.ucr.SISTRADE.model.TradeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TradeRequestRepository extends JpaRepository<TradeRequest, Integer> {

   List<TradeRequest> findByReceiverId(Integer receiverId);
   List<TradeRequest> findByRequestedProductId(Integer requestedProductId);
   List<TradeRequest> findByOfferedProductId (Integer offeredProductId);


}


