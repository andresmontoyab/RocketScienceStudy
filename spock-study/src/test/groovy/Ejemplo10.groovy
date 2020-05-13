import com.study.Person
import org.junit.Ignore
import spock.lang.FailsWith
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Timeout

//Toda clase que contenga nuestros tests extienden de Specification
class Ejemplo10 extends Specification {


    Person person;

    @Timeout()
    def "ejemplo bloque 1"() {
        setup:
        person = new Person()

        when:
        person.setName("Pedro")
        person.setLastname("Rodriguez")
        person.setAge(30)

        then:
        person.getName() == "Pedro"
        person.getLastname() == "Rodriguez"
        person.getAge() == 30
    }

    @Ignore
    def "ejemplo bloque 2"() {
        setup:
        person = new Person()

        when:
        person.setName("Pedro")
        person.setLastname("Rodriguez")
        person.setAge(30)

        then:
        matchesTheSettedData(person)
    }

    @IgnoreRest
    def "ejemplo bloque 3"() {
        setup:
        person = new Person()

        when:
        person.setName("Pedro")
        person.setLastname("Rodriguez")
        person.setAge(30)

        then:
        matchesTheSettedData(person)
    }

    @FailsWith
    def "ejemplo bloque 4"() {
        setup:
        person = new Person()

        when:
        person.setName("Pedro")
        person.setLastname("Rodriguez")
        person.setAge(30)

        then:
        matchesTheSettedData(person)
    }

    def matchesTheSettedData(person){
        person.getName() == "Pedro"
        person.getLastname() == "Rodriguez"
        person.getAge() == 30
    }



}
