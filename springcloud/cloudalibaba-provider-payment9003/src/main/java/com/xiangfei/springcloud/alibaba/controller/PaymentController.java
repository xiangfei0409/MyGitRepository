package alibaba.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.xiangfei.springcloud.entities.CommonResult;
import com.xiangfei.springcloud.entities.Payment;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/17 20:05
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L, new Payment(1L, "111s111111111111111"));
        hashMap.put(2L, new Payment(2L, "222s222222222222222"));
        hashMap.put(3L, new Payment(3L, "333s333333333333333"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "from mysql,serverPort: " + serverPort, payment);
        return result;
    }
}
