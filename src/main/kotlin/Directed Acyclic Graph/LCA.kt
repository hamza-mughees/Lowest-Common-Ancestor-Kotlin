class Node(val value: Int) {
    var ancestors = mutableListOf<Node>()
    var descendants = mutableListOf<Node>()
}

class DAG(root_val: Int) {
    val root: Node = Node(root_val)

    fun lca(p: Node, q: Node): Node {
        if (this.root.value.equals(p.value) or this.root.value.equals(q.value))
            return this.root

        if (p.value.equals(q.value))
            return p

        var comm_anc = mutableListOf<Node>()

        var p_anc = p.ancestors
        var q_anc = q.ancestors

        for (anc_of_p in p.ancestors)
            for (anc_of_q in q.ancestors)
                if (anc_of_p.value.equals(anc_of_q.value)) {
                    comm_anc.add(anc_of_p)
                    break
                }

        if (comm_anc.isEmpty())
            if (p.value > q.value)
                comm_anc.add(this.lca(p.ancestors[0], q))
            else
                comm_anc.add(this.lca(p, q.ancestors[0]))

        return comm_anc.maxBy { it.value }!!
    }
}