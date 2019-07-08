package cn.yjp.springbootconsumer.config.loadbalancer;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class GlobalRule implements IRule {

    private ILoadBalancer iLoadBalancer;

    /**
     * 自定义的负载均衡策略是始终取服务列表的第一个
     *
     * @param o
     * @return
     */
    @Override
    public Server choose(Object o) {
        List<Server> servers = iLoadBalancer.getAllServers();
        return servers.get(0);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.iLoadBalancer = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.iLoadBalancer;
    }
}

