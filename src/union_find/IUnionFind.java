package union_find;

public interface IUnionFind {
    void union(int p,int q);
    boolean isConnected(int p,int q);
    int find(int p);
    int count();
}
