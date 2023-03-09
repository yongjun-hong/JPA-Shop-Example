package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL) // Cascade 알아보기
    private List<OrderItem> orderItems = new ArrayList<>();
    @OneToOne(fetch = FetchType.LAZY) // FetchType 알아보기
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
    private LocalDateTime orderDate; // 주문 시간
    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문상태 [order , Cancel]

     // 연관관계 메서드

    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }
}
