import java.util.LinkedList;
import java.util.Queue;
/*
压入元素 (添加)：add ()、offer ()
相同：未超出容量，从队尾压入元素，返回压入的那个元素。
区别：在超出容量时，add () 方法会对抛出异常，offer () 返回 false

弹出元素 (删除)：remove ()、poll ()
相同：容量大于 0 的时候，删除并返回队头被删除的那个元素。
区别：在容量为 0 的时候，remove () 会抛出异常，poll () 返回 false

获取队头元素 (不删除)：element ()、peek ()
相同：容量大于 0 的时候，都返回队头元素。但是不删除。
区别：容量为 0 的时候，element () 会抛出异常，peek () 返回 null。
 */
public class TreeDepth {
    //递归法
    public int depth(TreeNode root){
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left,right) + 1;

    }
    //非递归法
    public int depth1(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        //基本思路是层序遍历树，一层完全遍历后，深度+1；
        //当前队列的长度就是这一层的节点数
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            depth++;
        }
        return depth;
    }
}
