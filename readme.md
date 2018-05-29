The most accurate and safe java8+ builder pattern.

Immutable object <br>
Safe modificators <br>
Clean code <br>
Functional constructor <br>

    public class Person {
    
        private String name;
        private String lastName;
    
        public static Supplier<PersonBuilder> builder = Person.PersonBuilder::new;
    
        public static class PersonBuilder {
    
            Person itself;
    
            public void withName(String name) {
                itself.name = name;
            }
    
            public void withLastName(String lastName) {
                itself.lastName = lastName;
            }
    
            PersonBuilder() {
                this.itself = new Person();
            }
    
            public PersonBuilder and(Consumer<PersonBuilder> input) {
                input.accept(this);
                return this;
            }
    
            public Person build() {
                return itself;
            }
        }
    
    }

Usage:

    Person p1 = Person.builder.get()
        .and( x -> x.withName("name"))
        .build();

    Person p2 = Person.builder.get()
        .and((x) -> x.withName("name"))
        .and((y)-> y.withLastName("last name"))
        .build();
