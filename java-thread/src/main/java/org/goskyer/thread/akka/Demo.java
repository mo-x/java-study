package org.goskyer.thread.akka;

import akka.actor.*;
import akka.japi.pf.ReceiveBuilder;

/**
 * akka 入门demo
 */
public class Demo {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("actor-demo1-java");
        ActorRef hello = system.actorOf(Props.create(Hello.class));
        hello.tell("Bob", ActorRef.noSender());
        hello.tell("Jay", ActorRef.noSender());
        hello.tell("zzq", ActorRef.noSender());
        hello.tell("女魔头", ActorRef.noSender());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            /* ignore */
        }
        system.shutdown();
        System.out.println("start");

        ActorSystem actorSystem = ActorSystem.create("actor-HelloLambda-java");
        ActorRef actorRef = actorSystem.actorOf(Props.create(HelloLambda.class));
        actorRef.tell("akka", ActorRef.noSender());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            /* ignore */
        }
        actorSystem.shutdown();
    }

    private static class Hello extends UntypedActor {

        public void onReceive(Object message) throws Exception {
            if (message instanceof String) {
                System.out.println("Demo " + message);// Demo Bob
            }
        }
    }

    private static class HelloLambda extends AbstractActor {

        public HelloLambda() {
            receive(ReceiveBuilder.match(String.class, s -> {
                System.out.println("Hello " + s);
            }).build());
        }

    }

}

