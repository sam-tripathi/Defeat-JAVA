import java.util.*;
public class Node {
	public Node parent;
	public Boolean endOfWord = false; //Does this Node mark the end of a particular word?
	public HashMap<Character,Node> children = new HashMap<Character,Node>();
}