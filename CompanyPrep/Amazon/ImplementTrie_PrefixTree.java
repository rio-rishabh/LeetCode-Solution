package CompanyPrep.Amazon;

public class ImplementTrie_PrefixTree {
    static class TrieNode{
        TrieNode children[];
        boolean isEndOfWord;

        public TrieNode(){
            this.children = new TrieNode[26];
            this.isEndOfWord = false;
        }
    }

    private final TrieNode root;
    public ImplementTrie_PrefixTree(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            int i = c -'a';  // this will give us the exact character from english alphabet like a-0, b-1, c-2, etc.
            if(node.children[i] == null){
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word){
        TrieNode node = find(word);
        return node != null && node.isEndOfWord;
    }

    public TrieNode find(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int i = c- 'a';
            if(node.children[i] == null){return null;}
            node = node.children[i];
        }
        return node;
    }
    public boolean startsWith(String prefix){
        return find(prefix) != null;
    }

    public static void main(String agrs[]){
        ImplementTrie_PrefixTree trie = new ImplementTrie_PrefixTree();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("apex"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}