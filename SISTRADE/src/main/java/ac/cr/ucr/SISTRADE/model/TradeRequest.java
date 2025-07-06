package ac.cr.ucr.SISTRADE.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_trade")
public class TradeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer requestId;
    @Column(nullable = false)
   private Integer receiverId;
    @Column(nullable = false)
    private Integer requestedProductId;
    @Column(nullable = false)
    private Integer offeredProductId;


    public TradeRequest(Integer requestId, Integer receiverId, Integer requestedProductId, Integer offeredProductId) {
        this.requestId = requestId;
        this.receiverId = receiverId;
        this.requestedProductId = requestedProductId;
        this.offeredProductId = offeredProductId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Integer getRequestedProductId() {
        return requestedProductId;
    }

    public void setRequestedProductId(Integer requestedProductId) {
        this.requestedProductId = requestedProductId;
    }

    public Integer getOfferedProductId() {
        return offeredProductId;
    }

    public void setOfferedProductId(Integer offeredProductId) {
        this.offeredProductId = offeredProductId;
    }
}
