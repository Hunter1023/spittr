package com.hunter.spittr.util;

import org.springframework.util.DigestUtils;

import java.util.Random;

public class MD5Util {

    //生成48位的加盐MD5
    public static String generate(String password) {

        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        //两个[0，99999999) 的随机整数拼接
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));

        //保证StringBuilder的长度为16
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }

        String salt = sb.toString();//将StringBuilder转化为字符串，即为SALT

        password = md5Hex(password + salt);//将密码与该盐拼接，进行MD5加密，生成32位的密码

        //将16位的salt与32位的（密码+salt）生成的MD5值再次拼接（因为MD5不可逆，这样能够重新获取salt），生成48位密码
        char[] chars = new char[48];
        for (int i = 0; i < 48; i += 3) {

            chars[i] = password.charAt(i / 3 * 2);

            char c = salt.charAt(i / 3);
            chars[i + 1] = c;
            chars[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return new String(chars);
    }

    //    校验密码是否正确
    public static boolean verify(String password, String md5) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            //分解48位的密码，获取salt 和 MD5值
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);

            cs2[i / 3] = md5.charAt(i + 1);
        }
        String salt = new String(cs2);
        //将输入的密码和解析所获得的盐相加生成MD5值，与原MD5值比较来确认密码
        return md5Hex(password + salt).equals(new String(cs1));
    }

    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    private static String md5Hex(String src) {
        return DigestUtils.md5DigestAsHex(src.getBytes());
    }


}
