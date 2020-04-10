import java.util.*;

/**
 * @author ariel.alcocer
 */

public class UnionFind {
    private int[] parents;
    private Map<String, Integer> elements;
    private int setsNumber;

    public UnionFind(int size) {
        this.parents = new int[size];
        for(int i = 0; i< parents.length; i++)   {
            parents[i] = i;
        }
        this.elements = new HashMap<>(size);
        this.setsNumber = size;
    }

    public int find(int i, int parent)   {
        if(i==parent)
            return i;
        else
            return find(parent, parents[parent]);
    }
    public int find(String element)   {
        return find(elements.get(element), parents[elements.get(element)]);
    }

    public void union(String x, String y) {
        int xRoot = find(x);
        int yRoot = find(y);
        System.out.println("X Root:"+xRoot+", Y Root:"+yRoot);
        if(xRoot!=yRoot) {
            parents[yRoot] = parents[xRoot];
            setsNumber--;
        }
    }

    public static void main(String[] args)  {
        UnionFind unionFind = new UnionFind(4);
        System.out.println("Before----------");
        System.out.println(Arrays.toString(unionFind.parents));
        String[] items= new String[]{"Fred", "Barney", "Betty", "Wilma"};
        for(int i=0;i<items.length;i++) {
            unionFind.elements.put(items[i],i);
        }
        System.out.println(unionFind.elements);

        System.out.println("----------After");
        unionFind.union("Fred", "Barney");
        System.out.println(Arrays.toString(unionFind.parents));
        System.out.println(unionFind.elements);
        unionFind.union("Barney", "Betty");
        System.out.println(Arrays.toString(unionFind.parents));
        System.out.println(unionFind.elements);
        unionFind.union("Betty", "Wilma");
        System.out.println(Arrays.toString(unionFind.parents));
        System.out.println(unionFind.elements);
    }
}
