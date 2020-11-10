package `Directed Acyclic Graph`

import org.junit.Assert.*
import org.junit.Test
import DAG
import Node

var dag: DAG = DAG(0)
var r: Node = dag.root

var n1 = Node(1)
var n2 = Node(2)
var n3 = Node(3)
var n4 = Node(4)
var n5 = Node(5)

fun constructDAG(): DAG {
    r.descendants = mutableListOf<Node>(n1)
    n1.ancestors = mutableListOf<Node>(r)
    n1.descendants = mutableListOf<Node>(n2, n3, n4, n5)
    n2.ancestors = mutableListOf<Node>(n1)
    n2.descendants = mutableListOf<Node>(n3, n4)
    n3.ancestors = mutableListOf<Node>(n1, n2)
    n4.ancestors = mutableListOf<Node>(n1, n2)
    n4.descendants = mutableListOf<Node>(n5)
    n5.ancestors = mutableListOf<Node>(n1, n4)

    return dag!!
}

class LCATest {
    var dag = constructDAG()

    @Test
    fun `LCA of 2 and 5 should be 1`() {
        assertEquals(dag.lca(n2, n5), n1)
    }

    @Test
    fun `LCA of 1 and 2 should be 1`() {
        assertEquals(dag.lca(n1, n2), n1)
    }

    @Test
    fun `LCA of 5 and 3 should be 1`() {
        assertEquals(dag.lca(n5, n3), n1)
    }

    @Test
    fun `LCA of 3 and 4 should be 2`() {
        assertEquals(dag.lca(n3, n4), n2)
    }
}