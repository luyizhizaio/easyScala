package com.kyrie.akka.supervisorstrategy;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

/**
 * Created by Kyrie on 2017/7/2.
 */
public class Main {

    public static void main(String [] args){

        ActorSystem system = ActorSystem.create("lifecycle", ConfigFactory.load("lifecycle.conf"));
        customstrategy(system);


    }

    public static void customstrategy(ActorSystem system){

        //创建监控策略actor
        ActorRef a = system.actorOf(Props.create(Supervisor.class),"Supervisor");
        //向supervisor 发送Props
        a.tell(Props.create(RestartActor.class), ActorRef.noSender());

        ActorSelection sel = system.actorSelection("akka://lifecycle/user/Supervisor/restartActor");


        //发送100条restart消息
        for (int i =0 ; i<100; i++){
            sel.tell(RestartActor.Msg.RESTART, ActorRef.noSender());
        }

    }



}
