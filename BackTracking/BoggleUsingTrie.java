package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell, where "adjacent"
 cells are those horizontally or vertically neighboring. The same letter cell
 may not be used more than once in a word.
 */
public class BoggleUsingTrie {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }


    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public static void main(String[] args){

        char[][] g1 = {{'c','a','t'},{'r','r','e'},{'t','o','n'}};

        /*HashSet<String> set1 = new HashSet<String>();
        set1.add("cat");
        set1.add("cater");
        set1.add("art");
        set1.add("toon");
        set1.add("moon");
        set1.add("not");
        set1.add("eat");
        set1.add("ton");*/
        String[] str = {"cat","cater","art","toon","moon","not","eat","ton"};

        BoggleUsingTrie obj = new BoggleUsingTrie();
        List<String> answer = obj.findWords(g1,str);
        //System.out.println("hashset size "+answer.size());
        for(String s : answer){
            System.out.println(s);
        }
    }



}

