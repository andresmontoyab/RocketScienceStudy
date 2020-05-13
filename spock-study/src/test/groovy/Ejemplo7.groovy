import com.study.Person
import spock.lang.Shared
import spock.lang.Specification

//Toda clase que contenga nuestros tests extienden de Specification
class Ejemplo7 extends Specification {

    Person person;

    def "ejemplo bloque 1"() {
        setup:
        person = new Person()
        person.setAge(30)
        when:
        int result = person.getAge()
        then:
        result == 30
    }

    def "ejemplo bloque 2"() {
        expect:
        person.getAge() == 30
    }
}
