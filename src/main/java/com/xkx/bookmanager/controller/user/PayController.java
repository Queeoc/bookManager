package com.xkx.bookmanager.controller.user;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.xkx.bookmanager.config.AlipayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PayController {

    @RequestMapping("/toPayPage")
    public String toPayPage(Model model) throws Exception {

        return "user/pay";
    }



    @RequestMapping("/toPay")
    @ResponseBody
    public String toPay(String orderid,String price,String title) throws Exception {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        try {
            //发送请求参数 orderid 订单id，price表示价格，title表示订单标题
            alipayRequest.setBizContent("{\"out_trade_no\":\"" + orderid + "\","
                    + "\"total_amount\":\"" + price + "\","
                    + "\"subject\":\"" + title+ "\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

            //请求
            String result;
            result = alipayClient.pageExecute(alipayRequest).getBody();
            return result;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
