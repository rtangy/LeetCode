import java.util.ArrayList;
import java.util.List;

// source https://leetcode-cn.com/problems/combinations/
public class Solution2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k || k < 1) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        backtracking(n, k, 1, path, res);
        return res;

    }

    private void backtracking(int n, int k, int begin, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 剪枝条件
        // 已经选择的数为 path.size(), 还需要选择的数为 k - path.size()
        // 如果从某起始位置起，已经不够 k - path.size()则没有必要继续进行
        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n, k, i + 1, path, res);
            path.remove(path.size() - 1);
        }

    }

}
