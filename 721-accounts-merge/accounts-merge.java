import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parent = new HashMap<>();
        Map<String, String> owner = new HashMap<>();

        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                parent.putIfAbsent(email, email);
                owner.put(email, name);
                union(parent, acc.get(1), email);
            }
        }

        Map<String, TreeSet<String>> groups = new HashMap<>();

        for (String email : parent.keySet()) {
            String root = find(parent, email);
            groups.putIfAbsent(root, new TreeSet<>());
            groups.get(root).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (String root : groups.keySet()) {
            List<String> merged = new ArrayList<>();
            merged.add(owner.get(root));
            merged.addAll(groups.get(root));
            result.add(merged);
        }

        return result;
    }

    private String find(Map<String, String> parent, String s) {
        if (!parent.get(s).equals(s)) {
            parent.put(s, find(parent, parent.get(s)));
        }
        return parent.get(s);
    }

    private void union(Map<String, String> parent, String a, String b) {
        String pa = find(parent, a);
        String pb = find(parent, b);
        if (!pa.equals(pb)) {
            parent.put(pb, pa);
        }
    }
}