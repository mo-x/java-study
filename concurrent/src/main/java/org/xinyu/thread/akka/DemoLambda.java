package org.xinyu.thread.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

public class DemoLambda {


    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("actor-demo1-java");
        ActorRef bob = system.actorOf(Greeter.props("Bob", "Howya doing"));
        ActorRef alice = system.actorOf(Greeter.props("Alice", "Happy to meet you"));
        bob.tell(new Greet(alice), ActorRef.noSender());
        alice.tell(new Greet(bob), ActorRef.noSender());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            /* ignore */
        }
        system.shutdown();
    }

    private static class Greet {
        public final ActorRef target;

        public Greet(ActorRef actor) {
            target = actor;
        }
    }

    private static Object AskName = new Object();

    private static class TellName {
        public final String name;

        TellName(String name) {
            this.name = name;
        }
    }

    private static class Greeter extends AbstractActor {
        private final String myName;
        private final String greeting;

        Greeter(String name, String greeting) {
            myName = name;
            this.greeting = greeting;
            receive(ReceiveBuilder.
                    match(Greet.class, g -> {
                        g.target.tell(AskName, self());
                    }).
                    matchEquals(AskName, a -> {
                        sender().tell(new TellName(myName), self());
                    }).
                    match(TellName.class, t -> {
                        System.out.println(greeting + ", " + t.name);
                    }).
                    build());
        }

        public static Props props(String name, String greeting) {
            return Props.create(Greeter.class, name, greeting);
        }
    }
}
