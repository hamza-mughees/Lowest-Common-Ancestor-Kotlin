class Node(val value: Int) {
    var left: Node? = null
    var right: Node? = null
}

class BinaryTree(root_val: Int) {
    val root: Node = Node(root_val)

    fun lca(p: Node, q: Node): Node? {
        return this._lca(this.root, p, q)
    }

    fun _lca(curr_node: Node?, p: Node, q: Node): Node? {
        if (curr_node == null) return null

        if (curr_node.value.equals(p.value) or curr_node.value.equals(q.value)) return curr_node

        var left_subtree = this._lca(curr_node.left, p, q)
        var right_subtree = this._lca(curr_node.right, p, q)

        if (left_subtree == null) return right_subtree
        if (right_subtree == null) return left_subtree

        return curr_node
    }
}