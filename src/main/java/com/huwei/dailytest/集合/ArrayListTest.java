package com.huwei.dailytest.集合;

import com.huwei.dailytest.实体类.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class ArrayListTest {
    public static void main(String[] args) {
        List<User> users=new ArrayList<User>(){
            {
                add(new User("zz",11));
                add(new User("ls",12));
                add(new User("ww",13));
            }
        };


        List<User> collect = users.stream().map(user -> changeUser(users)).collect(Collectors.toList());

        System.out.println(collect);
        

        int sum = users.stream().mapToInt(User::getAge).sum();
        System.out.println(sum);
    }

    private static User changeUser(List<User> users) {
        User u=new User();
        u.setName(users.get(0).getName());
        u.setAge(34);
        return u;
    }


//
//    @Data
//    @AllArgsConstructor
//    @NoArgsConstructor
//    public static class Person {
//        private String xing;
//        private Integer age;
//    }
//
//    public static void main(String[] args) {
//        List<Person> ll = null;
//        Optional.ofNullable(ll).ifPresent(lp->{
//            lp.forEach(p->{
//                p.getAge();
//            });
//        });
//
//        boolean empty = ll.isEmpty();
//
////        List<Person> list = new ArrayList<Person>() {
////            {
////                add(new Person("zhang", 11));
////                add(new Person("zhang", 13));
////                add(new Person("li", 16));
////                add(new Person("wang", 12));
////
////            }
////        };
////
////
////        Map<String, List<Person>> xingListMap = list.stream().collect(Collectors.groupingBy(Person::getXing));
////        xingListMap.forEach((k, v) -> {
////            System.out.println(k + " -> " + v);
////        });
//
//    }

}
