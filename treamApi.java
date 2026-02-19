import java.util.*;
import java.util.stream.Collectors;
class Employee {
    int id;
    String name;
    String email;
    double salary;

    public Employee(int id, String name, String email, double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }
}

class StreamApi{
    
    public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.addAll(Arrays.asList(10,21,30,40,50,60,77,80,90,100));
// Find all even numbers from a list of integers.
    list.stream().filter(n -> n%2 == 0 )
    .forEach(n->System.out.print(n +" "));
    System.out.println();

    List<Integer> ans1 = list.stream()
                        .filter(n -> n % 2 == 0)
                        .collect(Collectors.toList());
     System.out.println(ans1);                   


// Find all numbers greater than 50.
                         list.stream()
                        .filter(n -> (n>50))
                        .forEach(n->System.out.print(n +" "));
                        System.out.println();

  
// Convert all strings in a list to uppercase.
    List<String> ans2 = new ArrayList<>();
    ans2.addAll(Arrays.asList("vineet","ankur","abhi"));
    ans2.stream().map(n->n.toUpperCase()).
    forEach(n->System.out.print(n +" "));
    System.out.println();


// Remove all null values from a list.
     List<String> ans3 = new ArrayList<>();
    ans3.addAll(Arrays.asList("Aineet","ankur","abhi",null));
      ans3.stream()
      .filter(n-> n!= null)
      .forEach((n->System.out.print(n +" ")));
      System.out.println();


// Get the length of each string in a list.
   ans3.stream()
      .filter(n->n!=null)
      .forEach((n->System.out.print(n.length() +" ")));
      System.out.println();

// Find names starting with letter ‘A’.
ans3.stream()
      .filter(n ->  n!=null && n.startsWith("A")  )
      .forEach(n->System.out.println(n +" "));
      System.out.println();

// Find squares of all numbers.
List<Integer> ans4 = new ArrayList<>();
ans4.addAll(Arrays.asList(1,2,3,4,5));

ans4.stream()
     .map(n -> n*n)
     .forEach(n->System.out.print(n +" "));
     System.out.println();


// Filter employees with salary > 50,000.
List<Integer> ans5 = new ArrayList<>();
ans5.addAll(Arrays.asList(30000,50000,600000,700000));
ans5.stream()
.filter(n-> n>50000)
.forEach(n -> System.out.print(n +" "));
System.out.println();

// Get list of emails from list of employees.
List<Employee> employees = Arrays.asList(
    new Employee(1, "Vineet", "vineet@gmail.com", 60000),
    new Employee(2, "Ankur", "ankur@gmail.com", 45000),
    new Employee(3, "Abhi", "abhi@gmail.com", 75000),
    new Employee(4, "Ravi", "ravi@gmail.com", 50000)
);
List<String> emails = employees.stream()
                               .map(Employee::getEmail)
                               .collect(Collectors.toList());

System.out.println(emails);


// Count how many numbers are divisible by 3.

List<Integer> ans6 = List.of(3,6,9,5,12,7,15);
long count =ans6.stream()
    .filter(n -> n%3 == 0)
    .count();
    System.out.println(count);

// Sort a list of integers in ascending order.
ans6.stream().sorted().forEach(n->System.out.print(n +" "));
System.out.println();

// Sort a list of integers in descending order.
ans6.stream().sorted(Comparator.reverseOrder()).forEach(n->System.out.print(n +" "));

       
    }
}