import com.study.Publisher
import com.study.Subscriber
import com.study.SubscriberImpl
import spock.lang.Specification

//Toda clase que contenga nuestros tests extienden de Specification
class Ejemplo11 extends Specification {

    Publisher publisher;
    SubscriberImpl subscriber;

    def setup(){
        publisher = new Publisher()
        subscriber = Mock(SubscriberImpl)
        publisher.addSubscriber(subscriber)
    }

    def "test 1"(){
        when:

        publisher.sendMessage("hola")
        then:
        1 * subscriber.receive(_)
        1 * subscriber.receive("hola")
        0 * subscriber.receive("hola")
        (1..3) * subscriber.receive("hola")
        (1.._) * subscriber.receive("hola")
        (_..3) * subscriber.receive("hola")
        _ * subscriber.receive("hola")
    }




}
