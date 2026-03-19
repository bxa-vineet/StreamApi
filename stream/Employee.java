package  stream;
import java.util.*;
import java.util.stream.Collectors;

class Employeee {

    // Basic Info
    private int id;
    private String name;
    private String department;
    private String role;

    // Work-related Info
    private double salary;
    private int experience; // in years
    private double rating;  // performance rating 1.0 - 5.0

    // Constructor
    public Employeee(int id, String name, String department, String role, double salary, int experience, double rating) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.role = role;
        this.salary = salary;
        this.experience = experience;
        this.rating = rating;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    // toString (for printing)
    @Override
    public String toString() {
        return "Employeee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                ", experience=" + experience +
                ", rating=" + rating +
                '}';
    }

    // equals & hashCode (optional, useful for distinct or Map keys)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employeee)) return false;
        Employeee Employeee = (Employeee) o;
        return id == Employeee.id &&
                Double.compare(Employeee.salary, salary) == 0 &&
                experience == Employeee.experience &&
                Double.compare(Employeee.rating, rating) == 0 &&
                Objects.equals(name, Employeee.name) &&
                Objects.equals(department, Employeee.department) &&
                Objects.equals(role, Employeee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department, role, salary, experience, rating);
    }

    public static void main(String[] args) {
        List<Employeee> Employeees = Arrays.asList(
                new Employeee(1, "Amit", "IT", "Developer", 75000, 5, 4.6),
                new Employeee(2, "Vineet", "null", "Tester", 50000, 3, 4.2),
                new Employeee(3, "Rahul", "HR", "Manager", 90000, 10, 4.9),
                new Employeee(4, "Ankit", "Finance", "Analyst", 65000, 4, 4.4),
                new Employeee(5, "Rohit", "null", "Developer", 80000, 10, 4.8)
        );

        Employeees.stream()
                .filter(e -> e.getSalary() > 70000)
                .map(Employeee::getName)
                .forEach(System.out::println);

        Map<String,Long> ans1 = Employeees.stream()
                .collect(Collectors
                        .groupingBy(e -> e.getDepartment(),Collectors.counting()));
        System.out.println(ans1);

       Optional<Employeee>  maxper = Employeees.stream().max(Comparator.comparingDouble(Employeee::getRating));
       maxper.ifPresent(e-> System.out.println(e.name));

        Map<String,Double> ans2 = Employeees.stream()
                .collect(Collectors
                        .groupingBy(e -> e.getDepartment(),Collectors.averagingDouble(Employeee::getSalary)));
        System.out.println(ans2);

        List<String> name = Employeees.stream().filter(e->e.getName().startsWith("A")).sorted(Comparator.comparing(e->e.getName())).map(Employeee::getName).toList();
        System.out.println(name);

        DoubleSummaryStatistics stats = Employeees.stream().collect(Collectors.summarizingDouble(Employeee::getSalary));
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Average: " + stats.getAverage());

        Map<String,List<String>> ans3 = Employeees.stream().collect(Collectors.groupingBy(Employeee::getRole,Collectors.mapping(Employeee::getName,Collectors.toList())));
        System.out.println(ans3);

        List<String> ans4 = Employeees.stream().filter(e->e.getExperience() >= 10).map(e->e.getName()+"-"+ e.getExperience()).toList();
        System.out.println(ans4);
        String resu = Employeees.stream().filter(e->e.getSalary()>70000).map(e->e.getName()).collect(Collectors.joining(","));
        System.out.println(resu);

        Set<String> set = Employeees.
                          stream()
                          .filter(e-> Objects.isNull(e.getDepartment())).map(Employeee::getName).collect(Collectors.toSet());
        System.out.println(set);

        List<String> a = Employeees.stream().sorted(Comparator.comparing(Employeee::getSalary).reversed()).limit(3).map(Employeee::getName).toList();
        System.out.println(a);
    }
}