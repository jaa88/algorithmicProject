package a_001;

import java.util.*;

/**
 * 前向分词正大匹配法 NLP 分词算法中的一种
 * @author jianan
 * @Time 2019-05-21 23:53:01
 */
public class BinaryTreeAlgorithm {
    /*根据二叉树的顺序数组存储，构造二叉树链式存储*/
    public static TreeNode generateTreeNode(Integer[] nodeValueArr,Integer arrIndex){
        if(arrIndex>nodeValueArr.length-1){
            return null;
        }
        if(nodeValueArr[arrIndex]!=null){
            TreeNode treeNode=new TreeNode();
            treeNode.setNodeValue(nodeValueArr[arrIndex]);
            treeNode.setLeftTreeNode(generateTreeNode(nodeValueArr,arrIndex*2+1));
            treeNode.setRightTreeNode(generateTreeNode(nodeValueArr,arrIndex*2+2));
            return treeNode;
        }
        return null;
    }

    /*不断取第targetNum个“左”或“右”子树*/
    public static void getTargetDirectionAndTargetIndexNodeValue(TreeNode firstTreeNode,String leftOrRight,Integer targetNum){
        TreeNode targetNode=firstTreeNode;
        for(int i=0;i<targetNum;i++){
            if("right".equals(leftOrRight)){
                targetNode=targetNode.getRightTreeNode();
            }else {
                targetNode=targetNode.getLeftTreeNode();
            }
            if(targetNode==null){
                System.out.println("没找到啊小伙子");
                return;
            }
        }
        System.out.println("找到了："+targetNode.getNodeValue());
    }

   /* 广度优先遍历*/
    public static void doBreadthFirstSearch(TreeNode firstTreeNode){
        List<Integer> valueList=new ArrayList<>();//用于存储遍历结果
        Queue<TreeNode> valueQueue=new LinkedList();//使用队列，不断取当前元素的左右子节点插入队列，再以此出队列
        ((LinkedList) valueQueue).offer(firstTreeNode);
        while (valueQueue.size()>0){
            TreeNode targetTreeNode=(TreeNode) ((LinkedList) valueQueue).pop();
            valueList.add(targetTreeNode.getNodeValue());
            TreeNode leftTreeNode=targetTreeNode.getLeftTreeNode();
            TreeNode rightTreeNode=targetTreeNode.getRightTreeNode();
            if(leftTreeNode!=null){//遍历每一排，先左后右
                ((LinkedList<TreeNode>) valueQueue).offer(leftTreeNode);
            }
            if(rightTreeNode!=null){
                ((LinkedList<TreeNode>) valueQueue).offer(rightTreeNode);
            }
        }
        System.out.println("广度优先遍历结果数组为："+valueList);
    }

   /* 深度优先遍历*/
    public static void doDepthFirstSearch(TreeNode firstTreeNode){
        List<Integer> valueList=new ArrayList<>();
        Stack valueStack=new Stack();
        valueStack.add(firstTreeNode);
        while (valueStack.size()>0){
            TreeNode targetTreeNode=(TreeNode) valueStack.pop();
            valueList.add(targetTreeNode.getNodeValue());
            TreeNode leftTreeNode=targetTreeNode.getLeftTreeNode();
            TreeNode rightTreeNode=targetTreeNode.getRightTreeNode();
            if(rightTreeNode!=null){//从上至下，一直到底，先左后右，到底后不断回溯再探底
                valueStack.push(rightTreeNode);
            }
            if(leftTreeNode!=null){
                valueStack.push(leftTreeNode);
            }
        }
        System.out.println("深度优先遍历的结果是："+valueList);
    }

    private static Integer[] nodeValueArr={1,3,5,null,4,null,7,null,null,8,12,null,null,19};//二叉树的顺序存储结构

    public static void main(String[] args) {
        TreeNode firstTreeNode=BinaryTreeAlgorithm.generateTreeNode(nodeValueArr,0);//根据二叉树的数组存储结构，生成二叉树，返回首节点
        //BinaryTreeAlgorithm.getTargetDirectionAndTargetIndexNodeValue(firstTreeNode,"left",1);//不断取第targetNum个“左”或“右”子树
        BinaryTreeAlgorithm.doBreadthFirstSearch(firstTreeNode);//广度优先遍历
        BinaryTreeAlgorithm.doDepthFirstSearch(firstTreeNode);//深度优先遍历
    }
}










/*
               1
           3       5
             4         7*/
