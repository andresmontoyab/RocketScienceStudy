import com.study.Person
import spock.lang.Shared
import spock.lang.Specification

//Toda clase que contenga nuestros tests extienden de Specification
class Ejemplo1 extends Specification {

    //Indica que la variable person va a ser utilizada en más de un test dentro de la clase.
    //Lo recomendable es siempre inicializar la variable en éste punto.
    @Shared Person person = new Person()

    //sputnik

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
