package union_find;

/**
 * @program: agorithm-mooc
 * @description: Just after computing the root of p,set the id of each examined node to point to that root
 * @author: mhp
 * @create: 2020-12-10
 **/
public class PathCompressionQuickUnionUF implements IUnionFind{
    private final int[] parent;
    private final int[] size;
    public PathCompressionQuickUnionUF(int n){
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

    }
    private int findRoot(int n){
        while (parent[n]!=n){
            /*类似于链表的理解*/
            parent[n] = parent[parent[n]];
            n = parent[n];
        }
        return n;
    }

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
