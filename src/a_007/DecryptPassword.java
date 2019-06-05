package a_007;

import java.util.Scanner;

/**
 * 密码是我们生活中非常重要的东东，我们的那么一点不能说的秘密就全靠它了。哇哈哈. 接下来渊子要在密码之上再加一套密码，虽然简单但也安全。
 * 假设渊子原来一个BBS上的密码为zvbo9441987,为了方便记忆，他通过一种算法把这个密码变换成YUANzhi1987，这个密码是他的名字和出生年份，怎么忘都忘不了，而且可以明目张胆地放在显眼的地方而不被别人知道真正的密码。
 * 他是这么变换的，大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,就这么简单，渊子把密码中出现的小写字母都变成对应的数字，数字和其他的符号都不做变换，
 * 声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，如：X，先变成小写，再往后移一位，不就是y了嘛，简单吧。记住，z往后移是a哦。
 *
 * 输入 输入包括多个测试数据。输入是一个明文，密码长度不超过100个字符，输入直到文件结尾
 * 输出 输出渊子真正的密文
 *输出合并后的键值对（多行）
 * 例如：输入
 * YUANzhi1987
 *
 * 输出
 * zvbo9441987
 * @author jianan
 * @Time 2019-06-06 00:12:36
 */
public class DecryptPassword {
    public static void main(String[] args){
        System.out.println("请输入：");
        Scanner s=new Scanner(System.in);
        while (s.hasNextLine()){
            StringBuffer stringBuffer=new StringBuffer();
            String passwordStr=s.nextLine();
            for(int i=0;i<passwordStr.length();i++){
                Character targetChar=passwordStr.charAt(i);
                if(targetChar<='9' && targetChar>='0'){
                    stringBuffer.append(targetChar);
                }else if(targetChar<='z' && targetChar>='a'){
                    //对小写字母进行处理
                    stringBuffer.append(decryptLowercaseLetter(targetChar));
                }else if(targetChar<='Z' && targetChar>='A'){
                    stringBuffer.append(decryptHighercaseLetter(targetChar));
                }
            }
            System.out.println(stringBuffer.toString());
        }
    }

    /*解密小写字母*/
    public static char decryptLowercaseLetter(char targetChar){
        if(targetChar<='c' && targetChar>='a'){
            return '2';
        }else if(targetChar<='f' && targetChar>='d'){
            return '3';
        }else if(targetChar<='i' && targetChar>='g'){
            return '4';
        }else if(targetChar<='l' && targetChar>='j'){
            return '5';
        }else if(targetChar<='o' && targetChar>='m'){
            return '6';
        }else if(targetChar<='s' && targetChar>='p'){
            return '7';
        } else if(targetChar<='v' && targetChar>='t'){
            return '8';
        } else{
            return '9';
        }
    }

    /*解密大写字母*/
    public static char decryptHighercaseLetter(char targetChar){
        //先将大写字母转为小写字母
        //最好是直接ASCII码操作
        String tempStr=String.valueOf(targetChar);
        tempStr=tempStr.toLowerCase();
        char lowercaseLetter=tempStr.charAt(0);
        if(lowercaseLetter=='z'){
            return 'a';
        }else{
            return (char)(lowercaseLetter+1);
        }
    }
}
