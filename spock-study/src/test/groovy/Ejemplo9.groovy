import com.study.Calculadora
import com.study.Person
import spock.lang.Specification

//Toda clase que contenga nuestros tests extienden de Specification
class Ejemplo9 extends Specification {


    Person person;

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

    def matchesTheSettedData(person){
        person.getName() == "Pedro"
        person.getLastname() == "Rodriguez"
        person.getAge() == 30
    }



}
