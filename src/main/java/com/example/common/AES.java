package com.example.common;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Created by Liu on 2017/10/31.
 */
public class AES {

    /**
     * @Author：zhuangfei
     * @Description：AES 加密
     * @Date：9:47 2017/10/31
     */
    public static byte[] encrypt(String content, String password) {

        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            /** AES加密数据块分组长度必须为128比特，密钥长度可以是128比特、192比特、256比特中的任意一个
             注：如果你电脑上提示 java.security.InvalidKeyException: Illegal key size or default parameters
             那是因为你的jdk不支持192和256长度的加解密，需要去oracle官网上下载对应jdk的无限制版本，把那两个jar覆盖
             掉你本地目录%JDK_Home%\jre\lib\security里，
             对应覆盖local_policy.jar和US_export_policy.jar两个文件。如果还不行,在%JRE_Home%\lib\security目录下，也需要对应覆盖这两个文件 **/
            kgen.init(256, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKey key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES"); // 创建密码器
            byte[] byteContent = content.getBytes("UTF-8");
            cipher.init(Cipher.ENCRYPT_MODE, key); // 初始化
            byte[] result = cipher.doFinal(byteContent);
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        return  null;
    }

    /**
     * @Author：zhuangfei
     * @Description：AES 解密
     * @Date：9:54 2017/10/31
     */
    public static byte[] decrypt(byte[] content, String password) {

        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            /**  AES加密数据块分组长度必须为128比特，密钥长度可以是128比特、192比特、256比特中的任意一个
             注：如果你电脑上提示 java.security.InvalidKeyException: Illegal key size or default parameters
             那是因为你的jdk不支持192和256长度的加解密，需要去oracle官网上下载对应jdk的无限制版本，把那两个jar覆盖
             掉你本地目录%JDK_Home%\jre\lib\security里，
             对应覆盖local_policy.jar和US_export_policy.jar两个文件。如果还不行,在%JRE_Home%\lib\security目录下，也需要对应覆盖这两个文件 **/
            kgen.init(256, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);
            return result; // 加密

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**将二进制转换成16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static void main (String [] args) {
         //String content = "清华大学123AUTO";
         String content = "test1230000";
        String password = "12345678";

        //加密
        System.out.println("加密前：" + content);
        byte[] encryptResult = encrypt(content, password);
        String encryptResultStr = parseByte2HexStr(encryptResult);
        System.out.println("加密后：" + encryptResultStr);
        // System.out.println(Arrays.toString(encryptResult));
        //解密
        byte[] decryptFrom = parseHexStr2Byte(encryptResultStr);
        byte[] decryptResult = decrypt(decryptFrom,password);
        System.out.println("解密后：" + new String(decryptResult));

    }
        // 9B047F3C57E73C8FCCDE933260AD7BFBDC8FE2B4D4A2621402F731138ED3E348
        // 1F433B4789AF7ECE9035533A5D4F4867886CA87F76A61041FE6078BEE69DCB5E
        // 73C58BAFE578C59366D8C995CD0B9D6D
}
