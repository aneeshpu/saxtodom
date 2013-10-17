package com.aneeshpu.saxtodom;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParentBasedContentHandler extends DefaultHandler {

    private Node currentNode;

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attributes) throws SAXException {
        if (currentNode == null) {
            currentNode = new Node(qName);
            return;
        }

        final Node childNode = new Node(qName);
        currentNode.add(childNode);
        currentNode = childNode;

    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        if (currentNode == null) {
            throw new RuntimeException("nothing to end ");
        }

        //Need to retain the root element. Hence the null check
        if (currentNode.getParent() != null) {
            currentNode = currentNode.getParent();
        }
    }

    public Node currentNode() {
        return currentNode;
    }
}
