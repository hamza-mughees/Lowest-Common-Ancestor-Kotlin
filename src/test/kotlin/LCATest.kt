import org.junit.Assert.*
import org.junit.Test
import BinaryTree
import Node

fun constructTree(): BinaryTree {
    var t: BinaryTree = BinaryTree(3)
    var r: Node = t.root

    r.left = Node(5)
    r.right = Node(1)
    r.left?.left = Node(6)
    r.left?.right = Node(2)
    r.right?.left = Node(0)
    r.right?.right = Node(8)
    r.left?.right?.left = Node(7)
    r.left?.right?.right = Node(4)

    return t
}

/*
The above code generates the following tree:
            3
          /   \
        5       1
       / \     / \
      6   2   0   8
         / \
        7   4
*/

class LCATest {
    var t: BinaryTree = constructTree()
    var r: Node = t.root

    @Test
    fun `LCA of 5 and 1 should be 3`() {
        assertEquals(t.lca(r.left!!, r.right!!), r)
    }

    @Test
    fun `LCA of 6 and 4 should be 5`() {
        assertEquals(t.lca(r.left!!.left!!, r.left!!.right!!.right!!), r.left)
    }

    @Test
    fun `LCA of 1 and 0 should be 1`() {
        assertEquals(t.lca(r.right!!, r.right!!.left!!), r.right)
    }

    @Test
    fun `LCA of 7 and 4 should be 2`() {
        assertEquals(t.lca(r.left!!.right!!.left!!, r.left!!.right!!.right!!), r.left!!.right)
    }
}