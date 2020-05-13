import com.study.Person
import spock.lang.Shared
import spock.lang.Specification

//Toda clase que contenga nuestros tests extienden de Specification
class Ejemplo5 extends Specification {

    Person person;

    //no deberíamos usar éste método si lo que queremos es inicializar nuestros objetos una única vez.
    def setup(){
        println "Initializing..."
        person = new Person()
    }

    def "ejemplo bloque 1"() {
        given:
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
