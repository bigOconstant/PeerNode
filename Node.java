
    public class Node {
        private char data;
        
        private int level;
        private Node child;
        private Node parent;
        private Node sibling;

        Node(char data) {
            this.data = data;
            level = 0;
            this.child = null;
            this.parent = null;
            this.sibling = null;
        }

        Node(char data, Node parent) {
            this.data = data;
            this.child = null;
            this.parent = parent;
            this.sibling = null;
        }
        public char getData() {
            return data;
        }

        public int getLevel() {
            return level;
        }
        public void setLevel(int wolf) {
            this.level = wolf;
        }

        public Node getChild() {
            return child;
        }

        public Node getParent() {
            return parent;
        }
        public void setParent(Node wolf){
        	this.parent = wolf;
        }

        public Node getSibling() {
            return sibling;
        }

        public void setChild(Node child) {
            this.child = child;
        }

        public void setSibling(Node sibling) {
            this.sibling = sibling;
        }
    }
