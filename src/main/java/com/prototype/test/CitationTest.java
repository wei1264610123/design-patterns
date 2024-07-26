package com.prototype.test;

public class CitationTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Citation citation = new Citation();
        Citation clone = citation.clone();
        citation.setName("张三");
        clone.setName("李四");
        citation.show();
        clone.show();
    }
}
