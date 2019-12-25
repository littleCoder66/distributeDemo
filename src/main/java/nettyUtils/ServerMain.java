package nettyUtils;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * netty服务
 *
 * @author-liudongxu
 * @created 2019-12-24 18:21
 */
public class ServerMain {
    public static void main(String[] args) throws Exception{
        Map<String,Channel> channelMap = new HashMap<String, Channel>();
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup wokerGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,wokerGroup).channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .option(ChannelOption.SO_KEEPALIVE,true)
                    .option(ChannelOption.SO_BACKLOG,1024*1024*10)
                    .childHandler(new WebSocketChannelInitializer(channelMap));

            ChannelFuture channelFuture = serverBootstrap.bind(new InetSocketAddress(8080)).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            wokerGroup.shutdownGracefully();
        }

//        while(true){
//            if(channelMap.size()>0){
//                for(String key:channelMap.keySet()){
//                    Channel channel = channelMap.get(key);
//                    channel.writeAndFlush(new TextWebSocketFrame("服务端发送的信息"));
//                }
//            }
//        }
    }
}
