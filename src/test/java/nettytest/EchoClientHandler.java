package nettytest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.io.UnsupportedEncodingException;

/**
 * @author-liudongxu
 * @created 2018-11-16 20:13
 */
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws UnsupportedEncodingException {
        String clientMsg = "我是客户端"+Thread.currentThread().getName();
        byte[] res = clientMsg.getBytes("UTF-8");
        ByteBuf clientBuf = Unpooled.buffer(res.length);
        clientBuf.writeBytes(res);
        ctx.writeAndFlush(clientBuf);
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, ByteBuf in) throws UnsupportedEncodingException {
        byte[] req = new byte[in.readableBytes()];
        in.readBytes(req);
        String body = new String(req,"UTF-8");
        System.out.println("Client received: " +body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
