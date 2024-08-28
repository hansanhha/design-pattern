from collections import deque


class TreeNode:

    def __init__(self, val):
        self.val = val
        self.left: TreeNode | None = None
        self.right: TreeNode | None = None

def level_order_bfs(root: TreeNode | None) -> list[any]:
    queue: deque[TreeNode] = deque()
    queue.append(root)

    res = []
    while queue:
        node: TreeNode = queue.popleft()
        res.append(node.val)
        if node.left is not None:
            queue.append(node.left)
        if node.right is not None:
            queue.append(node.right)
    return res

# initialization
n1 = TreeNode(val=1)
n2 = TreeNode(val=2)
n3 = TreeNode(val=3)
n4 = TreeNode(val=4)
n5 = TreeNode(val=5)

n1.left = n2
n1.right = n3

n2.left = n4
n2.right = n5

print("======initialization=======")
print(level_order_bfs(n1))

# inserting
new = TreeNode(val=0)

n1.left = new
new.left = n2

print("======inserting=======")
print(level_order_bfs(n1))

# removing
n1.left = n2

print("======removing=======")
print(level_order_bfs(n1))