package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    public void shouldWork(){
        final TreeNode treeNode = new TreeNode(1,
                new TreeNode(0,
                        new TreeNode(0),
                        new TreeNode(0)),
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(1)));
        assertEquals(new TreeNode(1,null,
                new TreeNode(1,null,  new TreeNode(1))),
                Solution.pruneTree(treeNode));
    }
    @Test
    public void shouldWork2(){
        final TreeNode treeNode = new TreeNode(1,
                null,
                new TreeNode(0,
                        new TreeNode(0),
                        new TreeNode(1)));
        assertEquals(new TreeNode(1,null,
                        new TreeNode(0,null,  new TreeNode(1))),
                Solution.pruneTree(treeNode));
    }
    @Test
    public void shouldWork3(){
        final TreeNode treeNode = new TreeNode(1,
                new TreeNode(0, new TreeNode(0),
                new TreeNode(0)),
                        new TreeNode(1,
                        new TreeNode(0),new TreeNode(1)));
        assertEquals(new TreeNode(1,null,
                        new TreeNode(1,null,  new TreeNode(1))),
                Solution.pruneTree(treeNode));
    }
    @Test
    public void shouldWork4(){
        final TreeNode treeNode = new TreeNode(1,
                new TreeNode(0), new TreeNode(1,
                        new TreeNode(0,
                new TreeNode(0),
                        new TreeNode(0)),new TreeNode(1)));
        assertEquals(new TreeNode(1,null,
                        new TreeNode(1,null,  new TreeNode(1))),
                Solution.pruneTree(treeNode));
    }
}