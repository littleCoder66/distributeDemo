package nettyUtils;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.Map;

/**
 * @author-liudongxu
 * @created 2019-12-24 18:25
 */
public class ServerWebSocketRecHandle extends SimpleChannelInboundHandler<Object> {
    public Map<String,Channel> channelMap;
    public ServerWebSocketRecHandle(Map map){
        channelMap = map;
    }
    private WebSocketServerHandshaker handshaker;
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        channelMap.put(ctx.channel().remoteAddress().toString(),ctx.channel());
        super.channelActive(ctx);
        while(true){
            if(channelMap.size()>0){
                for(String key:channelMap.keySet()){
                    Channel channel = channelMap.get(key);
                    channel.writeAndFlush(new TextWebSocketFrame("服务端发送的信息"));
                }
            }
        }
//        while(true){
//            System.out.println("server channelActive    ");
//            ctx.channel().writeAndFlush(new TextWebSocketFrame("服务端信息"));
//        }

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println("channelRead0    ");
        ctx.channel().writeAndFlush(new TextWebSocketFrame("123456"));
        if(msg instanceof TextWebSocketFrame){
            System.out.println("收到消息："+((TextWebSocketFrame)msg).text());
            ctx.channel().writeAndFlush(new TextWebSocketFrame("123456"));
        }else if(msg instanceof BinaryWebSocketFrame){
            System.out.println("收到二进制消息："+((BinaryWebSocketFrame)msg).content().readableBytes());
            BinaryWebSocketFrame binaryWebSocketFrame=new BinaryWebSocketFrame(Unpooled.buffer().writeBytes("xxx".getBytes()));
            ctx.channel().writeAndFlush(binaryWebSocketFrame);
        }
        System.out.println("server handle message complete");
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelUnregistered");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelInactive");
    }

}
