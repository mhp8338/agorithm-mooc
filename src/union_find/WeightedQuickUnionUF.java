package union_find;

/**
 * @program: agorithm-mooc
 * @description: 带权重的UF
 * @author: mhp
 * @create: 2020-12-10
 **/
public class WeightedQuickUnionUF implements IUnionFind{

    private final int[] parent;
    private final int[] size;
    public WeightedQuickUnionUF(int n){
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

    }

    private int findRoot(int n){
        while (parent[n]!=n){
            n = parent[n];
        }
        return n;
    }

    /**
     * @Description: 大树并小树，缩减树的深度
     * @SpaceComplexity: O(1)
     * @TimeComplexity: O(log(n))
     * @Param: [p, q]
     * @Return: void
     * @Author: mhp
     */
    @Override
    public void union(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        if(pRoot == qRoot) return;
        if(size[pRoot] > size[qRoot]){
            /*
            * pRoot树上的节点多*/
            parent[qRoot] = pRoot;
            size[pRoot]+=size[qRoot];
        }else{
            parent[pRoot] = qRoot;
            size[qRoot]+=size[pRoot];
        }

    }

    /**
     * @Description:
     * @SpaceComplexity: O(1)
     * @TimeComplexity: O(log(n))
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
