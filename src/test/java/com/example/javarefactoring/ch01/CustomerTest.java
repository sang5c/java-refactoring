package com.example.javarefactoring.ch01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void statement() {
        Customer customer = new Customer("홍길동");
        System.out.println(customer.statement());

        Movie movie1 = new Movie("아바타", Movie.NEW_RELEASE);
        Movie movie2 = new Movie("어벤져스", Movie.REGULAR);
        Movie movie3 = new Movie("토이스토리", Movie.CHILDRENS);

        Rental rental1 = new Rental(movie1, 3);
        Rental rental2 = new Rental(movie2, 2);
        Rental rental3 = new Rental(movie3, 5);

        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);

        System.out.println(customer.statement());
        System.out.println(customer.htmlStatement());
    }
}
