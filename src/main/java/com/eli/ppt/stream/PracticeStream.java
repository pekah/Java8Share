package com.eli.ppt.stream;

import com.alibaba.fastjson.JSON;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeStream {

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

        // 找出2011年的所有交易并按交易额排序（从低到高） Comparator.comparing默认排序是升序
        List<Transaction> result1 = transactions.stream()
                .filter((transaction -> transaction.getYear() == 2011))
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println("找出2011年的所有交易并按交易额排序:" + JSON.toJSONString(result1));

        // 交易员都在哪些不同的城市工作过
        List<String> distinctCity = transactions.stream().map((t) -> t.getTrader().getCity()).distinct().collect(Collectors.toList());
        System.out.println("交易员都在哪些不同的城市工作过:" + JSON.toJSONString(distinctCity));

        // 查找所有来自于剑桥的交易员的姓名，并按姓名排序
        List<String> fromCambridgeName = transactions.stream()
                .map(Transaction::getTrader)
                .filter((t) -> t.getCity().equals("Cambridge"))
                .distinct().sorted(Comparator.comparing(Trader::getName))
                .map(Trader::getName).collect(Collectors.toList());
        System.out.println("查找所有来自于剑桥的交易员的姓名，并按姓名排序:" + fromCambridgeName);

        // 返回所有交易员的姓名字符串，按字母顺序排序
        String result2 = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().collect(Collectors.joining());
        System.out.println("返回所有交易员的姓名字符串，按字母顺序排序:" + result2);

        // 有没有交易员是在米兰工作的
        boolean isTraderInMilan = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println("有没有交易员是在米兰工作的:" + isTraderInMilan);

        // 打印生活在剑桥的交易员的所有交易额
        transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).forEach(System.out::println);

        System.out.println("--------");

        // 所有交易中，最高的交易额是多少。如果结果是null，会执行orElse方法，返回一个默认值。
        Optional<Integer> maxTradeValue = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        System.out.println("所有交易中，最高的交易额是多少:" + maxTradeValue.orElse(0));

        // 找出交易额最小的交易
        Optional<Transaction> minTransaction = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        minTransaction.ifPresent((t) -> System.out.println("找出交易额最小的交易:" + JSON.toJSONString(t)));

        // Stream转换成容器或Map
        Stream<String> stringStream = Stream.of("Java", "C", "PHP");
        Map<String, Integer> map = stringStream.collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println("list转map：" + map);


    }
}
