package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.transaction.annotation.Transactional;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    @Transactional
    public Person process(final Person person) throws Exception {
    	log.info(" BATCH item processing: PersonItemProcessor " + person);
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();
        if (firstName.equals("NIKOLINA")) {
        	throw new IllegalArgumentException("Illegal argument: " + firstName);
        }

        final Person transformedPerson = new Person(firstName, lastName);

        log.info(" BATCH item processed: PersonItemProcessor " + transformedPerson);

        return transformedPerson;
    }

}
