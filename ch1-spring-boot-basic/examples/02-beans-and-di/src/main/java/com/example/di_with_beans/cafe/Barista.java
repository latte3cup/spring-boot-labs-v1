package com.example.di_with_beans.cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Barista {
    private final CoffeeMachine machine;

    // 생성자 주입
    @Autowired
    public Barista(@Qualifier("premiumCoffeeMachine") CoffeeMachine machine) {
        this.machine = machine;
    }

    public String makeCoffee() {
        return machine.brew();
    }
}
