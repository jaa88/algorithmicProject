package a_006;

import a_004.CommonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
 * 从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 *
 * 输入：
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 * 坐标之间以;分隔。
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 * 下面是一个简单的例子 如：
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 起点（0,0）
 * +   A10   =  （-10,0）
 * +   S20   =  (-10,-20)
 * +   W10  =  (-10,-10)
 * +   D30  =  (20,-10)
 * +   x    =  无效
 * +   A1A   =  无效
 * +   B10A11   =  无效
 * +  一个空 不影响
 * +   A10  =  (10,-10)
 * 结果 （10， -10）
 *
 * 例如：输入
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 输出
 * 10,-10
 *
 * @author jianan
 * @Time 2019-06-03 22:33:26
 */

public class MoveCoordinates {
    public static void main(String[] args){
        System.out.println("请输入：");
        Scanner s=new Scanner(System.in);
        while (s.hasNextLine()){
            String inputString=s.nextLine();
            String[] arr=inputString.split(";");
            List<Integer> correctFormatNumArr=new ArrayList<>();
            List<Character> targetDirectionArr=new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                if(checkIsCorrectFormatString(arr[i])){
                    correctFormatNumArr.add(Integer.parseInt(arr[i].substring(1)));
                    targetDirectionArr.add(arr[i].charAt(0));
                }
            }
            // X轴
            int x=0;
            // Y轴
            int y=0;
            for(int i=0;i<correctFormatNumArr.size();i++){
                Character targetDirection=targetDirectionArr.get(i);
                Integer targetMoveSize=correctFormatNumArr.get(i);
                if(targetDirection=='A'){
                    x-=targetMoveSize;
                }else if(targetDirection=='D'){
                    x+=targetMoveSize;
                }else if(targetDirection=='W'){
                    y+=targetMoveSize;
                }else{
                    y-=targetMoveSize;
                }
            }
            System.out.println(x+","+y);
        }
    }

    public static boolean checkIsCorrectFormatString(String needCheckStr){
        if(needCheckStr==null || "".equals(needCheckStr) || needCheckStr.length()==1){
            return false;
        }
        char firstChar=needCheckStr.charAt(0);
        if(firstChar!='W' && firstChar!='D' && firstChar!='A' && firstChar!='S'){
            return false;
        }

        String numStr=needCheckStr.substring(1);
        return CommonUtil.isIntNum(numStr);
    }
}
