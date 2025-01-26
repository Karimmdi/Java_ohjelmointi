public class PersonDemo {
    public static void main(String[] args) {
        Person person1 = new Person("John","male",22, 185 );
        Person person2 = new Person("Alice:", "female", 22, 165 );

        PersonData(person1);
        System.out.println();
        PersonData(person2);
    }

    static void PersonData(Person person) {
        System.out.println("name: " + person.getName() + "Gender: " + person.getGender() +
                "Age: " + person.getAge() + " Height: " + person.getHeight() );


    }
}
