package union_find;

public class UnionFind implements IUnionFind {
    private final int[] parents;

    /**
     * @Description: constructor
     * @SpaceComplexity: O(n)
     * @TimeComplexity: O(n)
     * @Param: [n]
     * @Return:
     * @Author: mhp
     */
    public UnionFind(int n) {
        parents = new int[n];
        /*初始化*/
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

    }

    /**
     * @Description:
     * @SpaceComplexity: O(1)
     * @TimeComplexity: O(n)
     * @Param: [p, q]
     * @Return: void
     * @Author: mhp
     */
    @Override
    public void union(int p, int q) {
        int pParent = parents[p];
        int qParent = parents[q];
        /*所有pParent改为qParent*/
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == pParent) {
                parents[i] = qParent;
            }
        }

    }


    /**
     * @Description:
     * @SpaceComplexity: O(1)
     * @TimeComplexity: O(1)
     * @Param: [p, q]
     * @Return: boolean
     * @Author: mhp
     */
    @Override
    public boolean isConnected(int p, int q) {
        return parents[p] == parents[q];
    }

    @Override
    public int find(int p) {
        return 0;
    }

    @Override
    public int count() {
        return 0;
    }

    public static void main(String[] args) {

    }
}
