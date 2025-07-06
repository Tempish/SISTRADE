package ac.cr.ucr.SISTRADE.service;


import ac.cr.ucr.SISTRADE.model.TradeRequest;
import ac.cr.ucr.SISTRADE.repository.TradeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TradeRequestService {

    @Autowired
    TradeRequestRepository TradeRepository;

    public TradeRequest saveRequest(TradeRequest request){
        return this.TradeRepository.save(request);
    }

    public void deleteRequestById(Integer id){
        this.TradeRepository.deleteById(id);
    }

    public List<TradeRequest> findByUserId(Integer id){
        return this.TradeRepository.findByReceiverId(id);
    }

    public Optional<TradeRequest> findByRequestId(Integer id){

        return this.TradeRepository.findById(id);
    }

    public List<TradeRequest> findByOfferedProductId(Integer id){

        return this.TradeRepository.findByOfferedProductId(id);
    }


    public List<TradeRequest> findByRequestedProductId(Integer id){

        return this.TradeRepository.findByRequestedProductId(id);
    }



    }




