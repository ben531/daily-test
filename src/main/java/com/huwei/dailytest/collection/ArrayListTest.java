package com.huwei.dailytest.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class ArrayListTest {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Person {
        private String xing;
        private Integer age;
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>() {
            {
                add(new Person("zhang", 11));
                add(new Person("zhang", 13));
                add(new Person("li", 16));
                add(new Person("wang", 12));

            }
        };


        Map<String, List<Person>> xingListMap = list.stream().collect(Collectors.groupingBy(Person::getXing));
        xingListMap.forEach((k, v) -> {
            System.out.println(k + " -> " + v);
        });

    }

}
