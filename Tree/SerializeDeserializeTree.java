package Tree;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Anna on 6/5/17.
 */
public class SerializeDeserializeTree {
    private static final int MARKER = Integer.MIN_VALUE;

    //Pre order traversal
    public static void serialize(TreeNode node, ObjectOutputStream stream) throws java.io.IOException {
        if (node == null) {
            stream.writeInt(MARKER);
            return;
        }

        stream.writeInt(node.val);
        serialize(node.left, stream);
        serialize(node.right, stream);
    }

    public static TreeNode deserialize(ObjectInputStream stream) throws java.io.IOException {
        int val = stream.readInt();
        if (val == MARKER) {
            return null;
        }

        TreeNode node = new TreeNode(val);
        node.left = deserialize(stream);
        node.right = deserialize(stream);
        return node;
    }

}
