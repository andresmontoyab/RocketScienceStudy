import com.study.Calculadora
import com.study.Person
import spock.lang.Specification
import spock.lang.Unroll

//Toda clase que contenga nuestros tests extienden de Specification
class Ejemplo8 extends Specification {


    def "test de valores 1"() {
        expect:
        Calculadora.sumar(a, b) == c

        where:
        a << [5, 3]
        b << [1, 9]
        c << [6, 12]
    }

    def "test de valores 2"(){
        setup:
        Person person = new Person()
        person.setName(name)
        person.setLastname(lastname)
        person.setAge(age)

        expect:
        person.toString() == result

        where:
        name << ["Pedro", "Martin"]
        lastname << ["Perez", "Rodriguez"]
        age << [30, 25]
        result << ["This person is called Pedro Perez with the age of 30",
                   "This person is called Martin Rodriguez with the age of 25"]

    }

    @Unroll
    def "test de valores 3"(){
        setup:
        Person person = new Person()
        person.setName(name)
        person.setLastname(lastname)
        person.setAge(age)

        expect:
        person.toString() == result

        where:
        name << ["Pedro", "Martin"]
        lastname << ["Perez", "Rodriguez"]
        age << [30, 25]
        result << ["This person is called Pedro Perez with the age of 30",
                   "This person is called Martin Rodriguez with the age of 25"]

    }

}
