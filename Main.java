import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Main {
	
	public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Creating Tree");

        
        /*Define Nodes/leaves of tree */
        Node A = new Node('a');
        Node B = new Node('b');
        
        Node C = new Node('c');
        Node D = new Node('d');
        Node E = new Node('e');
        Node F = new Node('f');
        Node G = new Node('g');
        
        Node H = new Node('h');
        Node I = new Node('i');
        
        Node J = new Node('j');
        Node K = new Node('k');
        
        Node L = new Node('l');
        Node M = new Node('m');
        
        Node N = new Node('n');
        Node O = new Node('o');

        /* Set the relationships of the Nodes /in other words, define the tree */
        A.setChild(B);
        H.setParent(A);
        B.setParent(A);
        L.setParent(A);
        J.setParent(H);
        I.setParent(H);
        M.setParent(L);
        N.setParent(M);
        C.setParent(B);
        D.setParent(C);
        
        
        B.setChild(C);
        C.setChild(D);
        C.setSibling(F);
        F.setChild(G);
        G.setParent(F);
        F.setParent(B);
        D.setChild(E);
        B.setSibling(H);
        
        H.setChild(I);
        
        I.setSibling(J);
        
        J.setChild(K);
        K.setParent(J);
        H.setSibling(L);
        L.setChild(M);
        M.setChild(N);
        N.setChild(O);
       
        /*Print Out the Output */
        
        System.out.println("The output is = "+findNeighbor('c', A));
        System.out.println("The output is = "+findNeighbor('d', A));
        System.out.println("The output is = "+findNeighbor('f', A));
        System.out.println("The output is = "+findNeighbor('j', A));
        System.out.println("The output is = "+findNeighbor('k', A));
        System.out.println("The output is = "+findNeighbor('e', A));
        
	
	}
	/* This seems to be a pretty standard algorithm to find a Neighbor with a few example from the internet I just modified */
	public static char findNeighbor(char inputChar, Node input) {
        // Default value of peer is set to '-' meaning no peer exists
        char neighbor = '!';
        if (input == null){
            return neighbor;
        }
        
        Stack<String> order = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        do {
            // Set level of each node as 1 + its parents level
        	if(input.getParent() == null){
        		input.setLevel(0);
        	}
        	else
        		input.setLevel(input.getParent().getLevel()+1);
 
            /* If there are nodes in this level and if the last node is the
             input node,then the current node will be its peer*/
            if (!order.isEmpty() && (order.peek().charAt(0) == inputChar)
                    && order.peek().charAt(1) == (input.getLevel() + '0')) {
                neighbor = input.getData();
                break;
            }
            // If not, we push the current node data into order stack
            order.push(input.getData() + Integer.toString(input.getLevel()));
            // If current node has child, put it in queue and try accessing its siblings
            Node runner = input.getChild();
            if (runner != null) {
                queue.add(runner);
                while (runner.getSibling() != null) {
                    queue.add(runner.getSibling());
                    runner = runner.getSibling();
                }
            }
            // Remove the first node entered in queue and access its child and
            // siblings
            if(queue.isEmpty()){
            	input = null;
            }
            else
            	input = queue.remove();
            // Loop until all nodes removed
        } while (input != null);
        return neighbor;
    }
	
	
}
