import java.util.*;

public class Main_12541_Birthdates {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int entries = scanner.nextInt();
        List<Person> persons = new ArrayList<>(entries);
        for(int i=0;i<entries;i++)  {
            persons.add(new Person(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }
        Collections.sort(persons);
        System.out.println(persons.get(entries-1).name);
        System.out.println(persons.get(0).name);
    }
    static class Person implements Comparable<Person>   {
        String name;
        Date birthdate;
        Person(String name, int dd, int mm, int yyyy)    {
            this.name = name;
            Calendar calendar = new GregorianCalendar(yyyy, mm-1, dd);
            this.birthdate = calendar.getTime();
        }

        @Override
        public int compareTo(Person person) {
            return this.birthdate.compareTo(person.birthdate);
        }
    }
}
