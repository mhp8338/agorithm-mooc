package union_find;

/**
 * @program: agorithm-mooc
 * @description: quick union
 * @author: mhp
 * @create: 2020-12-10
 **/
public class QuickUnionUF implements IUnionFind{
    private final int[] parent;

    public QuickUnionUF(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /**
     * @Description: 找到节点的根
     * @SpaceComplexity: O(1)
     * @TimeComplexity: O(n)
     * @Param: [n]
     * @Return: int
     * @Author: mhp
     */
    private int findRoot(int n){
        while (n != parent[n]){
            n = parent[n];
        }
        return n;
    }


    /**
     * @Description: 
     * @SpaceComplexity: O(n)
     * @TimeComplexity: O(n)
     * @Param: [p, q]
     * @Return: void
     * @Author: mhp
     */
    @Override
    public void union(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        parent[pRoot] = qRoot;
    }

    /**
     * @Description:
     * @SpaceComplexity: O(n)
     * @TimeComplexity: O(n)
     * @Param: [p, q]
     * @Return: boolean
     * @Author: mhp
     */
    @Override
    public boolean isConnected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }


    @Override
    public int find(int p) {
        return 0;
    }

    @Override
    public int count() {
        return 0;
    }
}
