package com.xkx.bookmanager.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id ="2021000119679978";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCx3f3kbT/X84GCdmb65CO7KEODkLYR938Pe928bm+3bRmRptUeoQ+hbuwJC2By5WWs0NlnoS5e4sn+/vzCr7v8qyzCnXBnWOMNE0oWp9t9DDDV1/9jA9WVBk0p7Wy2jgRAMSNB+1i4G4zoBbxjshn1MqMfzdOEhoayupwPXfOPSg6ZQ2weqmM/66qq8vV8E4J3QAd75BLxBTO14CPVHf4sPxURgWZYj9TEsQLRfnu7O5fiApueU7zuT3EXpTeD7tjZcOV5DrL97Eie93KcWWl3JA67xmCbmhj3C8pZdKIc2JdLcHsN8buSioeaQp0P+gYscTiJxHHweyU6hJEodyozAgMBAAECggEARGrIs6oWacHf6kgTGqTQ3bgCKERs1IJoHJOf2lB8pojP0gfjaJG5inY5Us1Of0OgFZaMWeFVDeicnHqGzXh9jhZl9EJNL2OwiqIF2KsesX4T9t3L/dFGwbkXy23paFs+ZVbBYisFmGP4knNKYOrsMzYUKzKoDw0UGQHQ79RK0K2eWk93fgjaN1eT3Xmh9Du0UgexmZafnziLc+nIaKZoFkAsLYhUniWa5DRH3NaH2SPiGIBb1/B+xtiEw/qc9iVH9RPqwv2aEtILT8tety56x1ef/g+4TDwKgJ4kGEZTdaKqIY4pD/T47aIlOa/88UMCd+or+GzJTEDZzFmEVLVxEQKBgQDkyZKK1lSs2Fx52arJdPctGqrgChikkOV2CZV9fGXwsLLGirEf/0CvnQ7sLovP/oCVrEiEG6le1Gdyk4WRBRaYpEdO9M2manIfI1vOhbmP1R2o8/gcj//1ILOevatJPFsbYCyt3db6/OtHw+hfEXyQwvcOIsXOCz3yjENDl5xNOwKBgQDHBe5hnh8i7h3WWvWysiqtTrseG+5VBQ+9Yk8s+oB0xg2trDrfE6ct6RNy/F6p1Ndo+cGky5strZ6OcxHCQHg5HaJlCrlqutuEhmVbVOS+JRUo4i5zh/KqKYx+Cx9vR4r7iTRHOxJYU3X4ZdojqM1Cm1eo5fyaEzhISejIwU6naQKBgAvDub9d6hjBP3Acm0WkuBkfp+3BVycPNF1vfLppLSzFSUwgUZ9dlsvw/ZVzh0j4w0/u/gOdEIaJ0Y/4ugONCW5r9CbBO9n0201ymgPyqGoXAWFwui9t0DGgrtvY0PgBHIY52dJO+AEMBGU6U7afxZIEFIQrkZRYy6SvRb4yC52FAoGAN+eRm3gYFO7AENtCEuz7Ee2AoCeGXflq/26jAOZouOR9KSCs9MaHelzzKqR7TsdLruAhJdJPh5gyZp8qCN+lJZ4OZMWLadCNIv/BbtM84bB27iICnE8+uc+r+CfVr6NwBdH3jl6oe4kOJTUu/j9HUQNjrzzTJNBrSdsA+YtbNakCgYEApaSVKVTUAIYPwh4qX65Xms+s/7oGvJwQzgXY4aMRX2koXpXPOVtOqukcvqMjv88PXVx79eml9Y/twn+FBsRgWq1kpi1CND0XQrO+mnX0/c9XDMl0uMp6uyLXdsI9dLjYD2fH/oMnSFU94h7ICltAGtOnzRfIkhDfZIv/EMewABE=";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsd395G0/1/OBgnZm+uQjuyhDg5C2Efd/D3vdvG5vt20ZkabVHqEPoW7sCQtgcuVlrNDZZ6EuXuLJ/v78wq+7/Ksswp1wZ1jjDRNKFqfbfQww1df/YwPVlQZNKe1sto4EQDEjQftYuBuM6AW8Y7IZ9TKjH83ThIaGsrqcD13zj0oOmUNsHqpjP+uqqvL1fBOCd0AHe+QS8QUzteAj1R3+LD8VEYFmWI/UxLEC0X57uzuX4gKbnlO87k9xF6U3g+7Y2XDleQ6y/exInvdynFlpdyQOu8Zgm5oY9wvKWXSiHNiXS3B7DfG7koqHmkKdD/oGLHE4icRx8HslOoSRKHcqMwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问  return_url.jsp
    public static String return_url ="http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

