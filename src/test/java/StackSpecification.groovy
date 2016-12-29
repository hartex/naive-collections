import im.hartex.colletions.stack.LinkedListStack
import im.hartex.colletions.stack.ResizingArrayStack
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author hartex
 */
@Unroll
class StackSpecification extends Specification {

    def "throw NoSuchElementException when popping on empty #stack.class.getSimpleName()"() {
        when:
        stack.pop()

        then:
        thrown(NoSuchElementException)

        where:
        stack << getImplementations()
    }

    def "pushing, popping and size checking on #stack.class.getSimpleName() with 1 element"() {
        when:
        stack.push("item")

        then:
        stack.size() == 1
        !stack.isEmpty()
        stack.pop() == "item"

        where:
        stack << getImplementations()

    }

    def "pushing, popping and size checking in arbitrary order on #stack.class.getSimpleName()"() {
        when:
        stack.push("item1")
        stack.push("item2")
        stack.push("item3")
        stack.pop()
        stack.pop()
        stack.push("item2")

        then:
        stack.size() == 2
        !stack.isEmpty()
        stack.peek() == "item2"
        stack.pop() == "item2"

        where:
        stack << getImplementations()
    }

    def "iterating through not empty #stack.class.getSimpleName()"() {
        when:
        stack.push("item1")
        stack.push("item2")
        stack.push("item3")

        then:
        def iterator = stack.iterator()
        def index = stack.size()
        while (iterator.hasNext()) {
            assert iterator.next() == "item" + index--
        }

        where:
        stack << getImplementations()
    }

    def getImplementations() {
        [new LinkedListStack(), new ResizingArrayStack()]
    }

}
