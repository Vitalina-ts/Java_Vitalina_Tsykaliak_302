public class Main {
    public static void main(String[] args) {

        PersonRepository repo = new PersonRepository();

        System.out.println("\n=== VALID OBJECT CREATION ===");
        try {
            Person p1 = new Person("Alice", 25);
            repo.add(p1);
        } catch (InvalidDataException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("\n=== INVALID OBJECT CREATION ===");
        try {
            Person p2 = new Person("", -5);
            repo.add(p2); // не дійде
        } catch (InvalidDataException e) {
            System.out.println("InvalidDataException caught:");
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== SETTER VALIDATION ===");
        try {
            Person p3 = new Person("Bob", 30);
            repo.add(p3);

            p3.setAge(-10); // помилка
        } catch (InvalidDataException e) {
            System.out.println("Setter exception: " + e.getMessage());
        }

        System.out.println("\n=== FINAL REPOSITORY CONTENT ===");
        repo.getAll().forEach(System.out::println);
    }
}
