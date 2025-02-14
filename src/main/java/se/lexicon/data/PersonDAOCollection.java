package se.lexicon.data;
import se.lexicon.Person;

import java.util.Collection;
import java.util.HashSet;

public class PersonDAOCollection implements PersonDAO {

    HashSet<Person> personCollection = new HashSet<Person>();

    @Override
    public Person persist(Person person) {
        personCollection.add(person);
        return person;
    }

    @Override
    public Person findById(int id) {
        for (Person person : personCollection) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        for (Person person : personCollection) {
            if (person.getEmail().equalsIgnoreCase(email.strip())) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Collection<Person> findAll() {
        return new HashSet<Person>(personCollection);
    }

    @Override
    public void remove(int id) {
        for (Person person : personCollection) {
            if (person.getId() == id) {
                personCollection.remove(person);
            }
        }
    }
}
