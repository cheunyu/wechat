package com.scyb.wechat.verify.service.impl;

import com.scyb.wechat.verify.bo.VerifyServerBo;
import com.scyb.wechat.verify.service.IVerifyServerService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2016/2/2
 * Time:13:34
 */
public class VerifyServerServiceImpl implements IVerifyServerService {

    @Override
    public boolean verifyResults(VerifyServerBo vsBo) {
        String[] arr = new String[]{"scyb", vsBo.getTimestamp(), vsBo.getNonce()};
        Arrays.sort(arr);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            // �����������ַ���ƴ�ӳ�һ���ַ�������sha1����
            byte[] digest = md.digest(sb.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // ��sha1���ܺ���ַ�������signature�Ա�
        return tmpStr != null ? tmpStr.equals(vsBo.getSignature().toUpperCase()) : false;
    }

    /**
     * ���ֽ�����ת��Ϊʮ�������ַ���
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * ���ֽ�ת��Ϊʮ�������ַ���
     *
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }
}
