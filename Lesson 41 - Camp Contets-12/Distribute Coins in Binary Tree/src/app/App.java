package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int distributeCoins(TreeNode root) {
        MoveHolder moveHolder = new MoveHolder(0);
        getMoves(root, moveHolder);

        return moveHolder.moves;
    }

    public int getMoves(TreeNode node, MoveHolder moveHolder) {
        if (node == null) {
            return 0;
        }

        int leftCoin = getMoves(node.left, moveHolder);
        int rightCoin = getMoves(node.right, moveHolder);

        int change = rightCoin + leftCoin + (node.val - 1);

        moveHolder.moves += Math.abs(change);

        return change;
    }
}

class MoveHolder {
    int moves;

    public MoveHolder(int moves) {
        this.moves = moves;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}