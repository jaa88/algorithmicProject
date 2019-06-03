package a_007;

import java.util.*;

/**
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * 处理：
 * 1、 记录最多8条错误记录，循环记录，对相同的错误记录（净文件名称和行号完全匹配）只记录一条，错误计数增加；
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。
 *
 * 输入 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 * 输出 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
 *输出合并后的键值对（多行）
 * 例如：输入
 * E:\V1R2\product\fpgadrive.c   1325
 * 输出
 * fpgadrive.c 1325 1
 * @author jianan
 * @Time 2019-06-04 00:33:36
 */
public class RecordErrorFileNameAndLineNum {
    //定义一个队列，用于循环存储8个 name+lineNum拼接成的string
    public static Queue<String> fileAndLineQueue=new LinkedList<>();
    //记录fileName lineNum 对应的个数
    public static Map<String,Integer> fileAndLineMap=new HashMap<>();

    public static void main(String[] args){
        System.out.println("请输入：");
        Scanner s=new Scanner(System.in);

        while (s.hasNextLine()){
            String inputString=s.nextLine();
            String[] inputStrArr=inputString.split(" ");
            //fileName+"***"+lineNum
            //使用***分割拼接，方便使用
            String combineNameAndLine="";
            //fileName可能不是绝对地址 可能长度超过16
            String fileName="";
            if(inputStrArr[0].lastIndexOf("\\")!=-1){
                fileName=inputStrArr[0].substring(inputStrArr[0].lastIndexOf("\\")+1);
            }else{
                fileName=inputStrArr[0];
            }
            if(fileName.length()>16){
                fileName=fileName.substring(fileName.length()-16);
            }
            combineNameAndLine=fileName+"***"+inputStrArr[inputStrArr.length-1];

            //map中没有的，需要在队列中新增，同时更新map ；队列长度需要稳定在8
            if(fileAndLineMap.get(combineNameAndLine)==null){
                fileAndLineQueue.offer(combineNameAndLine);
                fileAndLineMap.put(combineNameAndLine,1);
                if(fileAndLineQueue.size()>8){
                    fileAndLineQueue.poll();
                }
            }else{
                fileAndLineMap.put(combineNameAndLine,fileAndLineMap.get(combineNameAndLine)+1);
            }
        }

        //顺序输出 队列中 对应的fileName lineNum，以及在map中对应的总数目
        while (fileAndLineQueue.size()>0){
            String targetFileAndLine=fileAndLineQueue.poll();
            String targetFileName=targetFileAndLine.split("\\*\\*\\*")[0];
            String targetLineNum=targetFileAndLine.split("\\*\\*\\*")[1];
            Integer totalNum=fileAndLineMap.get(targetFileAndLine);
            System.out.println(targetFileName+" "+targetLineNum+" "+totalNum);
        }
    }
}
