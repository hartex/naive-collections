package im.hartex.collections.specs

import im.hartex.colletions.bag.LinkedListBag
import im.hartex.colletions.bag.ResizingArrayBag
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author hartex
 */
@Unroll
class BagSpecification extends Specification {

    def "throw NullPointerException when adding a null to #bag.class.getSimpleName()"() {
        when:
        bag.add(null)

        then:
        thrown(NullPointerException)

        where:
        bag << getImplementations()
    }

    def "adding and size checking on #bag.class.getSimpleName()"() {
        when:
        bag.add("item1")
        bag.add("item2")
        bag.add("item3")
        bag.add("item2")

        then:
        bag.size() == 4
        !bag.isEmpty()

        where:
        bag << getImplementations()
    }

    def "iterating through not empty #bag.class.getSimpleName()"() {
        when:
        bag.add("item1")
        bag.add("item2")
        bag.add("item3")
        bag.add("item4")

        then:
        def iterator = bag.iterator()
        def index = bag.size()
        while (iterator.hasNext()) {
            assert iterator.next() == "item" + index--
        }

        where:
        bag << getImplementations()
    }

    def getImplementations() {
        [new LinkedListBag<>(), new ResizingArrayBag<>()]
    }
}