from collections import deque


class TreeNode:

    def __init__(self, val):
        self.val = val
        self.left: TreeNode | None = None
        self.right: TreeNode | None = None

def level_order(root: TreeNode | None) -> list[any]:
    queue: deque[TreeNode] = deque()
    queue.append(root)

    traversal = []
    while queue:
        node: TreeNode = queue.popleft()
        traversal.append(node.val)
        if node.left is not None:
            queue.append(node.left)
        if node.right is not None:
            queue.append(node.right)
    return traversal

def pre_order(root: TreeNode | None):
    if root is None:
        return

    print(root.val)
    pre_order(root.left)
    pre_order(root.right)

def in_order(root: TreeNode | None):
    if root is None:
        return

    in_order(root.left)
    print(root.val)
    in_order(root.right)

def post_order(root: TreeNode | None):
    if root is None:
        return

    post_order(root.left)
    post_order(root.right)
    print(root.val)

# initialization
n1 = TreeNode(val=1)
n2 = TreeNode(val=2)
n3 = TreeNode(val=3)
n4 = TreeNode(val=4)
n5 = TreeNode(val=5)
n6 = TreeNode(val=6)
n7 = TreeNode(val=7)

n1.left = n2
n1.right = n3

n2.left = n4
n2.right = n5

n3.left = n6
n3.right = n7

print("======initialization=======")
print(level_order(n1))

# inserting
new = TreeNode(val=0)

n1.left = new
new.left = n2

print("======inserting=======")
print(level_order(n1))

# removing
n1.left = n2

print("======removing=======")
print(level_order(n1))

# level order traversal
print("======level order traversal=======")
print(level_order(n1))

# pre order traversal
print("======pre order traversal=======")
pre_order(n1)

# in order traversal
print("======in order traversal=======")
in_order(n1)

# post order traversal
print("======post order traversal=======")
post_order(n1)