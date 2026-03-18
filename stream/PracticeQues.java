package stream;

import java.util.Arrays;
import java.util.*;

public class PracticeQues {
   public static  void main(String args[]){
       List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
       //  list.stream().forEach(System.out::println);

       //  list.stream().filter(x-> x%2==0).
       //  forEach(x -> System.out.println(x));

       //     list.stream().map(x-> x*x).
       //  forEach(x -> System.out.println(x));

       //   long count =list.stream().count();
       //   System.out.println(count);

       boolean result = list.stream()
               .findFirst()
               .filter(x -> x > 50)
               .isPresent();
       System.out.println(result);
   }


}
