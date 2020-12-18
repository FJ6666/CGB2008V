package cn.tedu.sp02.item.controller;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.service.ItemService;
import cn.tedu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ItemController {
    //注入业务对象
    @Autowired
    private ItemService itemService;
    //为了测试集群，这里注入端口号
    @Value("${server.port}")
    private int port;

    /**
     *
     * @param orderId 订单ID
     * @return
     */
    @GetMapping("/{orderId}")
    public JsonResult<Item> getItems(@PathVariable String orderId){
        log.info("orderId="+orderId+port);
        List<Item> items=itemService.getItems(orderId);
        return JsonResult.ok().msg("port="+port).data(items);
    }

    //@RequestBody：完整的接受POST请求协议提数据
    /**
     *减少商品库存
     * @param items 商品列表
     * @return 返回表示减少商品成功
     */
    @PostMapping("/decreaseNumber") //只处理post请求
    public JsonResult<Item> decreaseNumber(@RequestBody List<Item> items){
        itemService.decreaseNumbers(items);
        return JsonResult.ok().msg("减少商品库存成功");
    }
}
