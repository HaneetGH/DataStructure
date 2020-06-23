package com.technorapper.datastructure.ds;

import java.util.Arrays;

public class TestClass {


    public static void main(String[] args) {



        MyTreeNode<String> root = new MyTreeNode<>("Root");

        MyTreeNode<String> child1 = new MyTreeNode<>("Child1");
        child1.addChild("--->Grandchild1");
        child1.addChild("--->Grandchild2");
        child1.addChild("--->Grandchild3");

        MyTreeNode<String> child2 = new MyTreeNode<>("Child2");
        child2.addChild("---->Grandchild3");
     /*   implementation 'io.github.inflationx:calligraphy3:3.1.1'
        implementation 'io.github.inflationx:viewpump:2.0.3'*/
        root.addChild(child1);
        root.addChild(child2);
        root.addChild("Child3");

        root.addChildren(Arrays.asList(
                new MyTreeNode<>("Child4"),
                new MyTreeNode<>("Child5"),
                new MyTreeNode<>("Child6")
        ));

        for(MyTreeNode node : root.getChildren()) {
       //     System.out.println(((MyTreeNode)node.getData()).getChildren().get(0));
        }
        /*
        int xx = 0;
        int y = 0;
        int level = 10;
        int cLevel = 0;
        int ccLevel = 0;
        int depth = 5;
        MyTreeNode<String> root = new MyTreeNode<>("Root");


        while (cLevel < level) {
            MyTreeNode<String> childx = new MyTreeNode<>(xx + "" + y);
            while (ccLevel < 3) {

                childx.addChild(+xx + "" + y++);

                ccLevel++;


            }
            xx++;
            y = 0;
            ccLevel = 0;
            cLevel++;


            root.addChild(childx);
        }


        for (int i = 0; i < root.getChildren().size(); i++) {
            System.out.println(root.getChildren().get(i).getData());
            for (int x = 0; x < root.getChildren().get(i).getChildren().size(); x++) {


                System.out.println("---" + ((MyTreeNode) root.getChildren().get(i).getChildren().get(x)).getData());


            }
        }*/

    }
}
