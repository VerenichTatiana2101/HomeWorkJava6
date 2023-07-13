import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class Cat {
    int id;
    String name;
    int age;
    long passport;
    String breed;
    double weight;

    public Cat(int id, String name, int age, long passport, String breed, double weight){
        this.id = id;
        this.name = name;
        this.age = age;
        this.passport = passport;
        this.breed = breed;
        this.weight = weight;
    
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name=" + name +
                ", age=" + age +
                ", passport='" + passport + '\'' +
                ", breed='" + breed + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Cat cat = (Cat) obj;
        return id == cat.id && age == cat.age && Double.compare(cat.weight, weight) == 0 && passport == cat.passport && Objects.equals(name, cat.name) && Objects.equals(breed, cat.breed);
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, age, name, weight);
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat(1, "Тефтелька", 3, 643092345, "Ангорская", 4.2);
        Cat cat2 = new Cat(2, "Рыжий", 2, 622112345, "Мейн-кун", 6.2);
        Cat cat3 = new Cat(1, "Тефтелька", 3, 643092345, "Ангорская", 4.2);


        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat1.equals(cat3));//true

        HashSet<Cat> cats = new HashSet<>(Arrays.asList(cat1, cat2, cat3));
        System.out.println(cats);

        System.out.println("size " + cats.size());
        
    }
}




