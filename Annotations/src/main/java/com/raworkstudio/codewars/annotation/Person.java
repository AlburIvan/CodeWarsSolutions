package com.raworkstudio.codewars.annotation;

/**
 * Created by Ivan Alburquerque on 5/10/2017.
 */
@Builder(className = "PersonBuilder")
public class Person {

    private String firstName;

    private String lastName;

    private int age;

    private Gender gender;

    public Person() {}

    public Person(String firstName, String lastName, int age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    enum Gender {
        MASCULINO,
        FEMENINO
    }

    /*
    package com.raworkstudio.codewars.annotation;

    public class PersonBuilder {

        static class Builder {

            private String firstName;

            private String lastName;

            private int age;

            private Person.Gender gender;

            public com.raworkstudio.codewars.annotation.PersonBuilder.Builder withName(String name) {
                this.firstName = name;
                return this;
            }

            public com.raworkstudio.codewars.annotation.PersonBuilder.Builder withLastName(String lastName) {
                this.lastName = lastName;
                return this;
            }

            public com.raworkstudio.codewars.annotation.PersonBuilder.Builder withAge(int age) {
                this.age = age;
                return this;
            }

            public com.raworkstudio.codewars.annotation.PersonBuilder.Builder withGender(Person.Gender gender) {
                this.gender = gender;
                return this;
            }

            public com.raworkstudio.codewars.annotation.PersonBuilder.Builder decideGender() {
                this.gender = Person.Gender.MASCULINO;
                return this;
            }

            public Person build() {
                return new Person(firstName, lastName, age, gender);
            }
        }

    }

     */
}
