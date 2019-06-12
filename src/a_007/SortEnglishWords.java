package a_007;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 * 如，输入： Type   输出： epTy
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 * 如，输入： BabA   输出： aABb
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 * 如，输入： By?e   输出： Be?y
 *
 * 例如：输入
 * A Famous Saying: Much Ado About Nothing (2012/8).
 * 输出
 * A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 * @author jianan
 * @Time 2019-06-12 23:35:36
 */
public class SortEnglishWords {
    public static void main(String[] args){
        System.out.println("请输入");
        Scanner s=new Scanner(System.in);
        while (s.hasNextLine()){
            String needSortStr=s.nextLine();
            //定义Node列表，存储原始字母、小写字母组成的节点
            List<Node> charNodeList=new ArrayList<>();
            for(int i=0;i<needSortStr.length();i++){
                Character character=needSortStr.charAt(i);
                if((character<='Z' && character >='A')|| (character<='z' && character>='a')){
                    Node tempNode=new Node();
                    tempNode.setLowerChar((char)(character<'a'?character:character-('z'-'Z')));
                    tempNode.setPrimaryChar(character);
                    charNodeList.add(tempNode);
                }
            }
            //对Node list进行冒泡排序，因为冒泡是稳定的
            List<Node> sortNodeList=doNodeBubbleSort(charNodeList);

            //定义一个和原来的str同样大小的char数组,用于最终输出
            char[] outCharArr=new char[needSortStr.length()];
            int outCharArrIndex=0;
            int sortNodeListIndex=0;
            for(int i=0;i<needSortStr.length();i++){
                Character character=needSortStr.charAt(i);
                if((character<='Z' && character >='A')|| (character<='z' && character>='a')) {
                    outCharArr[outCharArrIndex]=sortNodeList.get(sortNodeListIndex).getPrimaryChar();
                    sortNodeListIndex++;
                }else{
                    outCharArr[outCharArrIndex]=character;
                }
                outCharArrIndex++;
            }
            StringBuffer stringBuffer=new StringBuffer();
            for(int i=0;i<outCharArr.length;i++){
                stringBuffer.append(outCharArr[i]);
            }
            System.out.println(stringBuffer.toString());
        }
    }

    static class Node{
        private Character primaryChar;
        private Character lowerChar;

        public Character getPrimaryChar() {
            return primaryChar;
        }

        public void setPrimaryChar(Character primaryChar) {
            this.primaryChar = primaryChar;
        }

        public Character getLowerChar() {
            return lowerChar;
        }

        public void setLowerChar(Character lowerChar) {
            this.lowerChar = lowerChar;
        }
    }


    /*对节点按节点的小写字母进行冒泡排序*/
    public static List<Node> doNodeBubbleSort(List<Node> nodeList){
        //大写小写的差额
        int balance='z'-'Z';//小写的大

        for(int i=0;i<nodeList.size();i++){//外层每一次遍历，确定第length-i-1位置的值
            for(int j=0;j<nodeList.size()-i-1;j++){//内层的每次遍历，是将最大的不断往后推
                if(nodeList.get(j).getLowerChar()>nodeList.get(j+1).getLowerChar()){
                    Node tempNode=nodeList.get(j);
                    nodeList.set(j,nodeList.get(j+1));
                    nodeList.set(j+1,tempNode);
                }
            }
        }
        return nodeList;
    }
}
