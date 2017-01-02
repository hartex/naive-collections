package im.hartex.collections.specs

import im.hartex.colletions.queue.LinkedListQueue
import im.hartex.colletions.queue.ResizingArrayQueue
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author hartex
 */
@Unroll
class QueueSpecification extends Specification {

    def "throw NullPointerException when adding null to the #queue.class.getSimpleName()"() {
        when:
        queue.enqueue(null)

        then:
        thrown(NullPointerException)

        where:
        queue << getImplementations()
    }

    def "throw NoSuchElementException when dequeuing on empty #queue.class.getSimpleName()"() {
        when:
        queue.dequeue()

        then:
        thrown(NoSuchElementException)

        where:
        queue << getImplementations()
    }

    def "enqueuing, peeking, dequeuing and size checking on #queue.class.getSimpleName() with 1 element"() {
        when:
        queue.enqueue("item")

        then:
        queue.size() == 1
        !queue.isEmpty()
        queue.peek() == "item"
        queue.dequeue() == "item"

        where:
        queue << getImplementations()
    }

    def "enqueuing, peeking, dequeuing and size checking in arbitrary order on #queue.class.getSimpleName()"() {
        when:
        queue.enqueue("item1")
        queue.enqueue("item2")
        queue.enqueue("item3")
        queue.enqueue("item4")
        queue.dequeue()
        queue.dequeue()
        queue.enqueue("item5")

        then:
        queue.size() == 3
        !queue.isEmpty()
        queue.peek() == "item3"
        queue.dequeue() == "item3"
        queue.peek() == "item4"
        queue.dequeue() == "item4"
        queue.size() == 1
        queue.dequeue() == "item5"
        queue.isEmpty()

        where:
        queue << getImplementations()
    }

    def "iterating through not empty #queue.class.getSimpleName()"() {
        when:
        queue.enqueue("item1")
        queue.enqueue("item2")
        queue.enqueue("item3")
        queue.enqueue("item4")

        then:
        def iterator = queue.iterator()
        def index = 1
        while (iterator.hasNext()) {
            assert iterator.next() == "item" + index++
        }

        where:
        queue << getImplementations()
    }

    def getImplementations() {
        [new LinkedListQueue<>(), new ResizingArrayQueue<>()]
    }
}