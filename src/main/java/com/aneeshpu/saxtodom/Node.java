package com.aneeshpu.saxtodom;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final String qName;
    private List<Node> children = new ArrayList<Node>();
    private Node parent;

    public Node(final String qName) {
        this.qName = qName;
    }


    public void add(final Node childNode) {
        this.children.add(childNode);
        childNode.setParent(this);
    }

    private void setParent(final Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

}
