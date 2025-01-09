
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeTest {

    @Test
    void add() {
        // given, when
        var bst = new BinarySearchTree<Integer>();

        /*
                       20
                 10         30
             5     12    25     33
         */
        bst.add(20);
        bst.add(10);
        bst.add(30);
        bst.add(5);
        bst.add(12);
        bst.add(25);
        bst.add(33);

        var order = bst.getPreOrder();
        while (order.hasNext()) {
            System.out.println(order.next());
        }

        // then
        assertThat(bst.size()).isEqualTo(7);
    }
}