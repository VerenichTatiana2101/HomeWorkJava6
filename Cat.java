import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Cat {
    int id;
    String name;
    int age;
    long passport;
    String breed;
    double weight;

    public Cat(int id, String name, int age, long passport, String breed, double weight) {
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
        return id == cat.id && age == cat.age && Double.compare(cat.weight, weight) == 0 && passport == cat.passport
                && Objects.equals(name, cat.name) && Objects.equals(breed, cat.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name, weight);
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat(1, "Тефтелька", 3, 643092345, "Мейн-кун", 6.5);
        Cat cat2 = new Cat(2, "Рыжий", 2, 622112345, "Мейн-кун", 6.2);
        Cat cat3 = new Cat(1, "Тефтелька", 3, 643092345, "Мейн-кун", 6.5);

        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat1.equals(cat3));// true

        HashSet<Cat> cats = new HashSet<>(Arrays.asList(cat1, cat2, cat3));
        System.out.println(cats);
        System.out.println("size " + cats.size());

        int res = evaluationRequest();
        String classcat = classCat(res);
        System.out.printf("Зарегестрированный кот: %s, Присвоенный титул: %s", cat1, classcat);

        

    }
    // запрос оценки параметров экспертом
    static int evaluationRequest() {
        Scanner input = new Scanner(System.in);
        System.out.print("Оценка тела от 0 до 35 баллов: ");
        int body = input.nextInt();
        System.out.print("Оценка головы от 0 до 40 баллов: ");
        int head = input.nextInt();
        System.out.print("Оценка шерсти от 0 до 35 баллов: ");
        int wool = input.nextInt();
        System.out.print("Оценка баланса/кондиции от 0 до 10 баллов: ");
        int balance = input.nextInt();
        input.close();
        return body + head + wool + balance;
    }

    static String classCat(int evaluation) {
        if (evaluation >= 105)
            return "show";
        if (evaluation < 105 && evaluation >= 90)
            return "breed";
        else
            return "pet";
    }

}
