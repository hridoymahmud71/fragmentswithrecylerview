package hridoy.aiz.fragmentswithrecyclerview;

import java.util.Objects;

public class Person {

    private String Name;
    private String TelephoneNumber;

    public Person(String name, String telephoneNumber) {
        Name = name;
        TelephoneNumber = telephoneNumber;
    }
    public Person(String name) {
        Name = name;
        TelephoneNumber = "";
    }


    public String getName() {
        return Name;
    }

    public Person setName(String name) {
        Name = name;
        return this;
    }

    public String getTelephoneNumber() {
        return TelephoneNumber;
    }

    public Person setTelephoneNumber(String telephoneNumber) {
        TelephoneNumber = telephoneNumber;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + Name + '\'' +
                ", TelephoneNumber='" + TelephoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(Name, person.Name) &&
                Objects.equals(TelephoneNumber, person.TelephoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, TelephoneNumber);
    }


}
