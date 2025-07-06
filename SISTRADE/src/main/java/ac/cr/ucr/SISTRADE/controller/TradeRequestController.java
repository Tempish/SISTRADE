package ac.cr.ucr.SISTRADE.controller;


import ac.cr.ucr.SISTRADE.model.TradeRequest;
import ac.cr.ucr.SISTRADE.service.TradeRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/trade")
public class TradeRequestController {

    @Autowired
    TradeRequestService requestService;

    @PostMapping
    public ResponseEntity<?> addTradeRequest(@Validated @RequestBody TradeRequest tradeRequest, BindingResult result){
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        List<TradeRequest> tradeRequestOp = this.requestService.findByUserId(tradeRequest.getReceiverId());

        if(tradeRequestOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("There's no requests");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(this.requestService.saveRequest(tradeRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByReceiverId(@PathVariable Integer id){
        Optional<TradeRequest> requestFind = this.requestService.findByRequestId(id);
        if(!requestFind.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This request doesn't exist");
        }

        return ResponseEntity.ok(requestFind);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){

        Optional<TradeRequest> tradeFind = this.requestService.findByRequestId(id);
        if(!tradeFind.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This request doesn't exist");
        }
        this.requestService.deleteRequestById(id);
        return ResponseEntity.noContent().build();
    }


}