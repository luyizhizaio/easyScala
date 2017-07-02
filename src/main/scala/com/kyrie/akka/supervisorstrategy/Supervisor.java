package com.kyrie.akka.supervisorstrategy;

import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.UntypedActor;
import akka.japi.Function;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kyrie on 2017/7/2.
 */
public class Supervisor extends UntypedActor {

    //错误后一分钟进行3次尝试
    private static SupervisorStrategy strategy =  new OneForOneStrategy(3,Duration.create(1,TimeUnit.MINUTES),
            new Function<Throwable,SupervisorStrategy.Directive>(){


                @Override
                public SupervisorStrategy.Directive apply(Throwable t) throws Exception {

                    if(t instanceof ArithmeticException){
                        System.out.println("meet ArithmeticException, just resume");
                        return SupervisorStrategy.resume(); //不做任何处理
                    }else if (t instanceof  NullPointerException){
                        System.out.println("meet NullPointerException,restart");
                        return SupervisorStrategy.restart(); //actor重启
                    }else if (t instanceof IllegalArgumentException){
                        return SupervisorStrategy.stop();
                    }else{
                        return SupervisorStrategy.escalate(); //向上抛出
                    }
                }
            });

    //使用自定义的监督策略
    @Override
    public SupervisorStrategy supervisorStrategy() {
        return strategy;
    }

    @Override
    public void onReceive(Object o) throws Exception {

        if (o instanceof Props){
            //根据Props对象创建Actor ， 会由当前的监督策略监督。
            getContext().actorOf((Props)o,"restartActor");
        }else{
            unhandled(o);
        }
    }
}
