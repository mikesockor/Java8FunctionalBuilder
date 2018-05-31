The most elegant and safe java8+ advanced builder pattern using lambda.

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
                // do your object validation here
                return itself;
            }
        }
    
    }

Usage:

    Person person = Person.builder.get()
        .and( x -> x.withName("name"))
        .build();

    Person person = Person.builder.get()
        .and((x) -> x.withName("name"))
        .and((y)-> y.withLastName("last name"))
        .build();

    Person person = Person.builder.get()
        .and($ -> {
            $.withName("name");
            $.withLastName("last name");
            })
        .build();

Or using reflection
        
    Person person = Person.builder.get()
        .and($ -> {
            $.setField("name", "Johny");
            $.setField("lastName", "Be Good");
        })
        .build();


that "advanced" pattern https://medium.com/beingprofessional/think-functional-advanced-builder-pattern-using-lambda-284714b85ed5
and many others required duplicate fields in Builder class with New invocation, which is ridiculous

that "advanced" pattern http://benjiweber.co.uk/blog/2014/11/02/builder-pattern-with-java-8-lambdas/
required some order of interfaces or boilerplate of interfaces

the rest of patterns use Setters which not safe 

 