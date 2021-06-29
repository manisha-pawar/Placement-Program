class GfG {
    Node buildTree(int inord[], int level[]) {
        //your code here
        map = new HashMap < > ();
        int n = inord.length;

        for (int i = 0; i < n; i++) {
            map.put(inord[i], i);
        }

        return buildTree(inord, 0, n - 1, level);
    }

    static HashMap < Integer, Integer > map;

    Node buildTree(int[] inorder, int ist, int iet, int[] level) {
        if (ist > iet) {
            return null;
        }

        Node node = new Node(level[0]);

        int idx = map.get(level[0]);

        int colse = idx - ist; //count of left sub-tree elements
        int corse = iet - idx; //count of right sub-tree elements

        int[] llo = new int[colse]; //left level-order
        int[] rlo = new int[corse]; //right level-order

        extract(level, idx, llo, rlo);

        node.left = buildTree(inorder, ist, idx - 1, llo);
        node.right = buildTree(inorder, idx + 1, iet, rlo);

        return node;

    }

    void extract(int[] level, int idx, int[] llo, int[] rlo) {
        int j = 0;
        int k = 0;

        for (int i = 1; i < level.length; i++) {
            int val = level[i];
            int pos = map.get(val); //position of val in inorder array

            if (pos < idx) {
                llo[j++] = val;
            } 
            else if (pos > idx) {
                rlo[k++] = val;
            }
        }
    }

}