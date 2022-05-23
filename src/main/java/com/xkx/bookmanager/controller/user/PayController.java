package com.xkx.bookmanager.controller.user;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.xkx.bookmanager.config.AlipayConfig;
import com.xkx.bookmanager.mapper.BookMapper;
import com.xkx.bookmanager.mapper.RecordMapper;
import com.xkx.bookmanager.pojo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


@Controller
@RequestMapping("/user")
public class PayController {
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private UserRecordController userRecordController;



    @RequestMapping("/toPayPage")
    public String toPayPage(Model model) throws Exception {

        return "user/pay";
    }


    @RequestMapping("/toPay/{bookId}/{price}")
    @ResponseBody
    public String toPay(Model model,HttpSession session,@PathVariable("bookId") String bookId, @PathVariable("price") String price) throws Exception {
        //获得初始化的AlipayClient
        String username = (String) session.getAttribute("username");
        Date date = new Date();
        long date1 = date.getTime();
        String orderid=username + "_"+date1 ;
        String title=username + "_"+date1;
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        try {
            //发送请求参数 orderid 订单id，price表示价格，title表示订单标题
            alipayRequest.setBizContent("{\"out_trade_no\":\"" + orderid + "\","
                    + "\"total_amount\":\"" + price + "\","
                    + "\"subject\":\"" + title + "\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

            //请求
            String result;
            result = alipayClient.pageExecute(alipayRequest).getBody();
            /*请求完成后操作*/
            int days = Integer.parseInt(price);
            userRecordController.renewBook(model,session,bookId);
            return result;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/toPayAtOnce/{price}")
    @ResponseBody
    public String toPayAtOnce(Model model,HttpSession session, @PathVariable("price") String price) throws Exception {
        //获得初始化的AlipayClient
        String username = (String) session.getAttribute("username");
        Date date = new Date();
        long date1 = date.getTime();
        String orderid=username + "_"+date1 ;
        String title=username + "_"+date1;
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        try {
            //发送请求参数 orderid 订单id，price表示价格，title表示订单标题
            alipayRequest.setBizContent("{\"out_trade_no\":\"" + orderid + "\","
                    + "\"total_amount\":\"" + price + "\","
                    + "\"subject\":\"" + title + "\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

            //请求
            String result;
            result = alipayClient.pageExecute(alipayRequest).getBody();
            /*请求完成后操作*/
            int days = Integer.parseInt(price);

            List<Record> record = recordMapper.getOwnRecord(username);
            Iterator<Record> it = record.iterator();
            while (it.hasNext()){
                Record r = (Record) it.next();
                long date2 = r.getLatestFineDay().getTime();
                if (date1 - date2 > 0) {
                    userRecordController.renewBook(model,session,r.getBookId());
                }
            }
                //userRecordController.renewBook(model,session,bookId,days);
            return result;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
