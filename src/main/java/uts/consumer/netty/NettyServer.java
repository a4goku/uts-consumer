package uts.consumer.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {

    private static class SingletonHolder{
        static final NettyServer instance = new NettyServer();
    }

    public static NettyServer getInstance(){
        return SingletonHolder.instance;
    }

    private EventLoopGroup bossGroup;

    private EventLoopGroup workerGroup;

    private ServerBootstrap b;

    private ChannelFuture cf;

    private NettyServer(){
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        b = new ServerBootstrap();
        b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel sc) throws Exception {
                        sc.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
                        sc.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
                        sc.pipeline().addLast(new NettyServerHandler());
                    }
                });
    }

    public void start(){
        try {
            this.cf = b.bind(8765).sync();
            System.err.println("服务器启动.....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ChannelFuture getChannelFuture(){
        return this.cf;
    }

    public void close(){
        try {
            this.cf.channel().close().sync();
            this.bossGroup.shutdownGracefully();
            this.workerGroup.shutdownGracefully();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
