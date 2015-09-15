package com.hczhang.ia.p5.practise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by steven on 9/14/15.
 */
public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1.  Find all transactions in the year 2011 and sort them by value (small to high).
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(toList());

        // 2.  What are all the unique cities where the traders work?
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());

        // 3.  Find all traders from Cambridge and sort them by name.
        transactions.stream()
                .map(transaction -> transaction.getTrader())
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(toList());

        // 4.  Return a string of all traders’ names sorted alphabetically.
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .reduce((n1, n2) -> n1 + n2);

        // 5.  Are any traders based in Milan?
        transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .anyMatch(trader -> trader.getCity().equals("Milan"));

        // 6.  Print all transactions’ values from the traders living in Cambridge.
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .forEach(t -> System.out.println(t.getValue()));

        // 7.  What’s the highest value of all the transactions?
        transactions.stream()
                .max(Comparator.comparing(Transaction::getValue));

        // 8.  Find the transaction with the smallest value.
        transactions.stream()
                .max(Comparator.comparing(Transaction::getValue));
    }
}
