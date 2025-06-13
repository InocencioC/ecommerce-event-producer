package com.ecommerce.ecommerce_event_producer.producer.infrastructure.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ecommerce.ecommerce_event_producer.producer.domain.service.PurchaseService;

@Component
public class PurchaseEventScheduler {
private final PurchaseService purchaseService;

    public PurchaseEventScheduler(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Scheduled(fixedRate = 1000) // Gera evento a cada 5 segundos
    public void generatePurchaseEvent() {
        // Usar Virtual Threads para o agendamento
        Thread.ofVirtual().start(() -> {
            System.out.println("Attempting to simulate purchase..."); // Adicionar log para depuração
            purchaseService.simulatePurchase();
        });
    }
}
