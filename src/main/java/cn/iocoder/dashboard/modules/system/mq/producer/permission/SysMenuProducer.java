package cn.iocoder.dashboard.modules.system.mq.producer.permission;

import cn.iocoder.dashboard.modules.system.mq.message.permission.SysMenuRefreshMessage;
import cn.iocoder.dashboard.util.json.JSONUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Menu 菜单相关消息的 Producer
 */
@Component
public class SysMenuProducer {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 发送 {@link SysMenuRefreshMessage} 消息
     */
    public void sendMenuRefreshMessage() {
        SysMenuRefreshMessage message = new SysMenuRefreshMessage();
        stringRedisTemplate.convertAndSend(SysMenuRefreshMessage.TOPIC, JSONUtils.toJSONString(message));
    }

}