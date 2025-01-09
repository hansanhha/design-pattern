import java.util.*;

/*
    소스 코드 참고
    https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/datastructures/binarysearchtree/BinarySearchTree.java
    https://www.hello-algo.com/en/chapter_tree/binary_search_tree/#74-binary-search-tree
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private int size;

    private TreeNode root = null;

    public class TreeNode {
        T element;
        TreeNode left, right;

        public TreeNode(T element) {
            this.element = element;
            left = right = null;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean add(T e) {
        if (contains(e))
            return false;

        root = addRec(root, e);
        size++;
        return true;
    }

    // 재귀적으로 이진 트리에 값을 삽입
    private TreeNode addRec(TreeNode node, T e) {
        // 리프 노드 찾기
        if (node == null) {
            node = new TreeNode(e);
        } else {
            // 삽입하려는 값이 노드의 값보다 작은 경우 왼쪽 서브트리로 이동
            if (e.compareTo(node.element) < 0) {
                node.left = addRec(node.left, e);
            } else { // 큰 경우 오른쪽 서브트리로 이동
                node.right = addRec(node.right, e);
            }
        }

        return node;
    }

    // 값이 존재하는 경우 노드 삭제
    public boolean remove(T e) {
        if (!contains(e))
            return false;

        root = removeRec(root, e);
        size--;
        return true;
    }

    // 재귀적으로 값을 삭제하는 메서드
    private TreeNode removeRec(TreeNode node, T e) {
        if (node == null)
            return null;

        // 삭제할 값과 현재 노드의 값 비교
        int gap = e.compareTo(node.element);

        // 현재 노드보다 값이 작은 경우 왼쪽 서브 트리에서 삭제
        if (gap < 0) {
            node.left = removeRec(node.left, e);
        } else if (gap > 0) { // 현재 노드보다 값이 큰 경우 오른쪽 서브 트리에서 삭제
            node.right = removeRec(node.right, e);
        } else { // 현재 노드와 값이 일치하는 경우 - 삭제하려는 노드를 찾음

            /*
                삭제하려는 노드의 오른쪽 서브 트리만 있거나 서브 트리가 아예 없는 경우 (0~1개)
                삭제할 노드의 위치에 오른쪽 서브 트리를 둠
             */
            if (node.left == null) {
                return node.right;

                /*
                    삭제하려는 노드의 왼쪽 서브 트리만 있거나 서브 트리가 아예 없는 경우 (0~1개)
                    삭제할 노드의 위치에 왼쪽 서브 트리를 둠
                 */
            } else if (node.right == null) {
                return node.left;

                /*
                    삭제하려는 노드의 서브 트리가 2개인 경우

                    아래의 이진 탐색 트리에서 10처럼 두 개의 서브 트리(8, 13)를 가진 노드를 삭제할 때
                    이진 탐색 트리의 특성을 유지하려면
                    왼쪽 서브 트리에서 가장 큰 값 또는 오른쪽 서브 트리에서 가장 작은 값을 선택하여 삭제할 노드의 값을 덮어씌우면 됨

                    왼쪽 서브 트리에서 가장 큰 값: 9
                    오른쪽 서브 트리에서 가장 작은 값: 11
                     ---------------------------------------
                                         19
                     ---------------------------------------
                             10                    25
                     ---------------------------------------
                         8        13          22       28
                     ---------------------------------------
                      6    9   11    14
                     ---------------------------------------
                 */
            } else { // 오른쪽 서브트리에서 가장 작은 값을 찾은 후, 현재 노드의 값을 덮어씌우고 찾은 노드를 삭제
                var tmp = findMin(node.right);
                var oldValue = tmp.element;
                node.element = oldValue;
                node.right = removeRec(node.right, oldValue);
            }
            /*
                왼쪽 서브트리에서 가장 큰 값을 찾는 방법도 있음
                var biggestInLeftSubTree = findMax(node.left);
                var oldValue = biggestInLeftSubTree.element;
                node.element = oldValue;
                node.right = remove(node.left, oldValue);
             */
        }

        return node;
    }

    // 루프문을 돌아 값을 삭제하는 메서드
    public void removeLoop(T e) {
        if (root == null || !contains(e))
            return;

        TreeNode cur = root, pre = null;
        // 루프문을 돌아 삭제하려는 값을 찾는 과정
        while (cur != null) {
            var curE = cur.element;
            if (curE.equals(e))
                break;
            pre = cur;

            if (e.compareTo(curE) < 0)
                cur = cur.left;
            else
                cur = cur.right;
        }

        // 삭제하려는 노드를 찾지 못한 경우
        if (cur == null)
            return;

        // 삭제하려는 노드의 자식 노드가 없거나 1개인 경우
        if (cur.left == null || cur.right == null) {
            var child = cur.left != null ? cur.left : cur.right;

            // 삭제하려는 노드가 루트 노드인 경우 자식 노드를 루트 노드로 변경
            if (cur == root) {
                root = child;
            } else { // 내부 노드인 경우 부모 노드의 참조를 자식 노드로 변경
                if (pre.left == cur)
                    pre.left = child;
                else
                    pre.right = child;
            }
            /*
                삭제하려는 노드의 자식 노드가 2개인 경우
                오른쪽 서브 트리의 가장 작은 값을 가진 노드 또는 왼쪽 서브 트리의 가장 큰 값을 가진 노드를 찾고
                해당 노드의 값을 덮어씌운 후 찾은 노드를 제거하면 됨
             */
        } else { // 오른쪽 서브트리에서 가장 작은 값을 찾은 후, 현재 노드의 값을 덮어씌우고 찾은 노드를 삭제
            var tmp = findMin(cur.right);
            removeLoop(tmp.element);
            cur.element = tmp.element;
            size--;
        }
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    private TreeNode findMax(TreeNode node) {
        while (node.right != null)
            node = node.right;
        return node;
    }

    // 루프문을 돌아 값을 가진 노드를 찾는 메서드
    public Optional<TreeNode> find(T e) {
        if (!contains(e))
            return Optional.empty();

        TreeNode cur = root;
        // 값을 찾는 과정
        while (cur != null) {
            if (e.equals(cur.element))
                return Optional.of(cur);

            var gap = e.compareTo(cur.element);
            if (gap < 0)
                cur = cur.left;
            else
                cur = cur.right;
        }
        return Optional.empty();
    }

    public boolean contains(T e) {
        return containsRec(root, e);
    }

    // 재귀적으로 값을 찾는 메서드
    private boolean containsRec(TreeNode node, T e) {
        // 리프 노드까지 도달했지만 값을 찾지 못한 경우
        if (node == null)
            return false;

        var gap = e.compareTo(node.element);

        // 찾는 값이 현재 노드의 값보다 작은 경우, 왼쪽 서브 트리로 이동
        if (gap < 0)
            return containsRec(node.left, e);
        else if (gap > 0) // 찾는 값이 현재 노드의 값보다 큰 경우, 오른쪽 서브 트리로 이동
            return containsRec(node.right, e);
        else // 값을 찾은 경우
            return true;
    }

    public int height() {
        return height(root);
    }

    // 재귀적으로 트리의 높이를 계산하는 헬퍼 메서드
    private int height(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public int depth(TreeNode node) {
        if (node == null)
            return -1;

        return depth(root, node, 0) + 1;
    }

    private int depth(TreeNode from, TreeNode to, int depth) {
        if (from == null)
            return -1;

        var gap = from.element.compareTo(to.element);

        if (gap < 0)
            return depth(from.left, to, depth + 1);
        else if (gap > 0)
            return depth(from.right, to, depth + 1);
        else
            return depth;
    }

    public abstract class Order implements Iterator<T> {
        /*
            자바의 이터레이터는 동시성 처리를 지원하지 않는 fail-fast임
            구조적 수정 감지를 위해 현재 트리의 길이를 캡처
        */
        private final int expectedSize = size;
        // 이터레이터에서 반환할 노드 값들을 담은 리스트를 필드로 보관
        protected final Deque<T> elements = new LinkedList<>();

        @Override
        public boolean hasNext() {
            if (expectedSize != size)
                throw new ConcurrentModificationException();

            return !elements.isEmpty();
        }

        @Override
        public T next() {
            if (expectedSize != size)
                throw new ConcurrentModificationException();

            return elements.pop();
        }
    }

    public Iterator<T> getLevelOrder() {
        return new Order() {
            /*
                인스턴스 초기화 단계에서 레벨 순회를 돌아 노드값을 저장
                자바의 연결 리스트는 스택 기능을 지원하는 Deque 인터페이스를 구현함
             */
            {
                Deque<TreeNode> q = new LinkedList<>();
                q.offer(root);

                while (!q.isEmpty()) {
                    var cur = q.pop();
                    elements.offer(cur.element);

                    if (cur.left != null)
                        q.offer(cur.left);
                    if (cur.right != null)
                        q.offer(cur.right);
                }
            }
        };
    }

    public Iterator<T> getPreOrder() {
        return new Order() {
            {
                Deque<TreeNode> q = new LinkedList<>();
                q.offer(root);

                while (!q.isEmpty()) {
                    var cur = q.pop();
                    elements.offer(cur.element);

                    if (cur.left != null)
                        q.offer(cur.left);
                    if (cur.right != null)
                        q.offer(cur.right);
                }
            }
        };
    }

    public Iterator<T> getInOrder() {
        return new Order() {
            {
                Deque<TreeNode> q = new LinkedList<>();
                q.offer(root);
                var cur = root;

                while (cur != null || !q.isEmpty()) {
                    while (cur != null) {
                        q.offer(cur);
                        cur = cur.left;
                    }

                    cur = q.pop();
                    elements.offer(cur.element);

                    cur = cur.right;
                }
            }
        };
    }

    public Iterator<T> getPostOrder() {
        return new Order() {
            {
                Deque<TreeNode> q = new LinkedList<>();
                q.offer(root);

                while (!q.isEmpty()) {
                    var cur = q.pop();
                    elements.offer(cur.element);

                    if (cur.left != null)
                        q.offer(cur.left);

                    if (cur.right != null)
                        q.offer(cur.right);
                }
            }
        };
    }
}
