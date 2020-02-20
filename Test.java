public class BinarySearchTree {
    private static class Node{
        private int val;
        private Node left;
        private Node right;
        public Node(int val){
            this.val=val;
        }
    }
    private Node root;
    public BinarySearchTree(){
        this.root=null;
    }

    public boolean serach(int key){
        Node cur=root;
        while(cur!=null){
            if(cur.val==key){
                return true;
            }else if(cur.val<key){
                cur=cur.right;
            }else{
                cur=cur.left;
            }
        }
        return false;
    }

    public boolean insert(int key){
        Node node=new Node(key);
        if(root==null){
            root=node;
            return true;
        }
        Node parent=null;
        Node cur=root;
        while(cur!=null){
            if(cur.val==key){
                return false;
            }else if(cur.val<key){
                parent=cur;
                cur=cur.right;
            }else{
                parent=cur;
                cur=cur.left;
            }
        }
        if(key<parent.val){
            parent.left=node;
        }else{
            parent.right=node;
        }
        return true;
    }

    public boolean remove(int key){
        Node parent=null;
        Node cur=root;
        while (cur!=null){
            if(cur.val==key){
                removeNode(parent,cur);
                return true;
            }else if(cur.val<key){
                parent=cur;
                cur=cur.right;
            }else{
                parent=cur;
                cur=cur.left;
            }
        }
        return false;
    }
    private void removeNode(Node parent,Node cur){
        if(cur.left==null){
            if(cur==root){
                root=cur.right;
            }else if(cur==parent.left){
                parent.left=cur.right;
            }else{
                parent.right=cur.right;
            }
        }else if(cur.right==null){
            if(cur==root){
                root=cur.left;
            }else if(cur==parent.left){
                parent.left=cur.left;
            }else{
                parent.right=cur.left;
            }
        }else{
            Node goantparent=cur;
            Node goant=cur.right;
            while(goant.left!=null){
                goantparent=goant;
                goant=goant.left;
            }
            cur.val=goant.val;
            if(goant==goantparent.left){
                goantparent.left=goant.right;
            }else{
                goantparent.right=goant.right;
            }
        }
    }

    public void inorderTraversal(Node root){
        if(root==null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val+" ");
        inorderTraversal(root.right);
    }

    public void postorderTraversal(Node root){
        if(root==null){
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.val+" ");
    }

    public Node getRoot() {
        return root;
    }
}

public class Test {
    public static void main(String[] args) {
        BinarySearchTree tree=new BinarySearchTree();
        int[] arr={3,9,7,4,1,6,2,8,5};
        for(int i:arr){
            tree.insert(i);
        }
        tree.inorderTraversal(tree.getRoot());
        System.out.println();
        tree.postorderTraversal(tree.getRoot());
        System.out.println();
        System.out.println(tree.serach(6));
        System.out.println(tree.serach(22));
        System.out.println(tree.remove(4));
        System.out.println(tree.remove(12));
        tree.inorderTraversal(tree.getRoot());
        System.out.println();
        tree.postorderTraversal(tree.getRoot());
        System.out.println();
    }
    public static void main2(String[] args) {
        Set<Integer> set=new TreeSet<>();
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);
        System.out.println(set.contains(2));
        Iterator<Integer> iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static void main1(String[] args) {
        Map<Integer,String> map=new TreeMap<>();
        map.put(1,"苹果");
        map.put(1,"苹果");
        map.put(2,"香蕉");
        map.put(3,"草莓");
        System.out.println(map);
        for(Integer key:map.keySet()){
            System.out.print(key+" ");
        }
        for(String val:map.values()){
            System.out.print(val+" ");
        }
        System.out.println();
        for(HashMap.Entry<Integer,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}

