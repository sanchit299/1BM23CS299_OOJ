import java.util.Scanner;

class WrongAgeException extends Exception {
    public String toString() {
        return "WrongAgeException";
    }
}

class Father {
    int age;

    Father(int age) throws WrongAgeException {
        if (age < 0) {
            throw new WrongAgeException();
        }
        this.age = age;
    }

    int getAge() {
        return age;
    }
}

class Son extends Father {
    int sonAge;

    Son(int fatherAge, int sonAge) throws WrongAgeException {
        super(fatherAge);
        if (sonAge < 0 || sonAge >= fatherAge) {
            throw new WrongAgeException();
        }
        this.sonAge = sonAge;
    }

    int getSonAge() {
        return sonAge;
    }
}

public class lab7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Enter Father's age: ");
            int fatherAge = scanner.nextInt();

            Father f1 = new Father(fatherAge);
            System.out.println("Father's age: " + f1.getAge());
            System.out.print("Enter Son's age: ");
            int sonAge = scanner.nextInt();

            Son s1 = new Son(fatherAge, sonAge);
            System.out.println("Son's age: " + s1.getSonAge());

        } catch (WrongAgeException e) {
            System.out.println("Exception caught: " + e);
        } finally {
            scanner.close();
        }
    }
}

