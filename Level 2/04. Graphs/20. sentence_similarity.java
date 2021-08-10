public class Solution {
    /**
     * @param words1: 
     * @param words2: 
     * @param pairs: 
     * @return: Whether sentences are similary or not?
     */
    static HashMap<String,String>parent;
    static HashMap<String,Integer>rank;

    public boolean areSentencesSimilarTwo(List<String> words1, List<String> words2, List<List<String>> pairs) {
        //create DSU
        parent = new HashMap<>();
        rank = new HashMap<>();

        for(int i=0; i < pairs.size();i++) {
            String w1 = pairs.get(i).get(0);
            String w2 = pairs.get(i).get(1);

            if(parent.containsKey(w1) == false) {
                parent.put(w1,w1);
                rank.put(w1,0);
            }
            if(parent.containsKey(w2) == false) {
                parent.put(w2,w2);
                rank.put(w2,0);
            }


            String l1 = find(w1);
            String l2 = find(w2);

            if(l1.equals(l2) == false) {
                //merge on the basis rank
                int r1 = rank.get(l1);
                int r2 = rank.get(l2);

                if(r1 < r2) {
                    parent.put(l1,l2);
                }
                else if(r1 > r2) {
                    parent.put(l2,l1);
                }
                else {
                    parent.put(l1,l2);
                    rank.put(l2,rank.get(l2) + 1);
                }
            }
        }



        //similarity check
        if(words1.size() != words2.size()) {
            return false;
        }

        for(int i=0; i < words1.size();i++) {
            String w1 = words1.get(i);
            String w2 = words2.get(i);

            if(w1.equals(w2)) {
                continue;
            }

            if(parent.containsKey(w1) == false || parent.containsKey(w2) == false || parent.get(w1).equals(parent.get(w2)) == false) {
                return false;
            }
        }

        return true;
    }

    public String find(String x) {
        if(parent.get(x).equals(x) == true) {
            return x;
        }

        String temp = find(parent.get(x));
        parent.put(x,temp); //path compression

        return temp;
    }
}