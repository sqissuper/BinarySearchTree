package binarysearchtree;

class BinarySearchTree {
    static class BSNode {
        public int val;
        public BSNode left;
        public BSNode right;
        public BSNode(int val) {
            this.val = val;
        }
    }
    public BSNode root = null;

    public BSNode search(int val) {
        if(root == null) return null;
        BSNode cur = root;
        if(cur.val == val) {
            return cur;
        } else if(cur.val < val) {
            cur = cur.left;
        } else {
            cur = cur.right;
        }
        return null;
    }

    public boolean insert(int val) {
        BSNode bsNode = new BSNode(val);
        if(root == null) {
            root = bsNode;
            return true;
        }
        BSNode cur = root;
        BSNode parent = null;
        while(cur != null) {
            if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > val) {
                parent = cur;
                cur = cur.left;
            } else {
                return false;
            }

        }
        if(parent.val < val) {
            parent.right = bsNode;
        } else {
            parent.left = bsNode;
        }
        return true;
    }

    public void remove(int val) {
        if(root == null) return;
        BSNode cur = root;
        BSNode p = null;
        if(cur.val < val) {
            p = cur;
            cur = cur.left;
        } else if (cur.val > val) {
            p = cur;
            cur = cur.right;
        } else {
            removeNode(p,cur,val);
        }
    }
    public void removeNode(BSNode p,BSNode cur,int val){
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            } else if(p.left == cur) {
                p.left = cur.right;
            } else if(p.right == cur) {
                p.right = cur.right;
            }
        } else if(cur.right == null) {
            if(cur == root) {
                root = cur.left;
            } else if(p.right == cur) {
                p.right = cur.left;
            } else if(p.left == cur) {
                p.left = cur.left;
            }
        } else {
            BSNode tp = cur;
            BSNode target = cur.right;
            while(target.left != null) {
                tp = target;
                target = target.left;
            }
            cur.val = target.val;

            if(tp.left == target) {
                tp.left = target.right;
            } else {
                tp.right = target.right;
            }
        }


    }
}
public class TestDemo {


    public static void prevTravel(BinarySearchTree.BSNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        prevTravel(root.left);
        prevTravel(root.right);
    }
    public static void midTravel(BinarySearchTree.BSNode root) {
        if(root == null) return;
        midTravel(root.left);
        System.out.print(root.val + " ");
        midTravel(root.right);
    }
    public static void main(String[] args) {

        BinarySearchTree bs = new BinarySearchTree();
        bs.insert(1);
        bs.insert(4);
        bs.insert(2);
        bs.insert(9);
        bs.insert(6);
        bs.insert(7);
        bs.remove(1);


        prevTravel(bs.root);
        midTravel(bs.root);
    }
}
