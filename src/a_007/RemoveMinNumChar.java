package a_007;

import java.util.*;

/**
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 *
 * 输入 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 * 输出 删除字符串中出现次数最少的字符后的字符串。
 *
 * 例如：输入
 * abcdd
 *
 * 输出
 * dd
 */
public class RemoveMinNumChar {
    public static void main(String[] args){
        System.out.println("请输入：");
        Scanner s=new Scanner(System.in);
        while (s.hasNextLine()){
            String inputStr=s.nextLine();
            Map<Character,Integer> characterIntegerMap=new HashMap<>();
            for(int i=0;i<inputStr.length();i++){
                char targetChar=inputStr.charAt(i);
                Integer targetCharAppearNum=1;
                if(characterIntegerMap.containsKey(targetChar)) {
                    targetCharAppearNum=characterIntegerMap.get(targetChar)+1;
                }
                characterIntegerMap.put(targetChar,targetCharAppearNum);
            }

            //获取字符出现最少的
            Integer minNum=null;
            Iterator<Map.Entry<Character,Integer>> itA=characterIntegerMap.entrySet().iterator();
            while (itA.hasNext()){
                Map.Entry<Character,Integer> mapEntry=itA.next();
                int targetCharNum=mapEntry.getValue();
                if(minNum==null){
                    minNum=targetCharNum;
                }else if(targetCharNum<minNum){
                    minNum=targetCharNum;
                }
            }

            //minNumCharArr用于存放字符串中出现次数最多的字符
            List<Character> minNumCharArr=new ArrayList<>();
            Iterator<Map.Entry<Character,Integer>> it=characterIntegerMap.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry<Character,Integer> mapEntry=it.next();
                if(mapEntry.getValue().equals(minNum)){
                    minNumCharArr.add(mapEntry.getKey());
                }
            }

            StringBuffer stringBuffer=new StringBuffer();
            for(int i=0;i<inputStr.length();i++){
                if(!minNumCharArr.contains(inputStr.charAt(i))){
                    stringBuffer.append(inputStr.charAt(i));
                }
            }
            System.out.println(stringBuffer.toString());
        }

    }
}
