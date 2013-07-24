package Akka;

/**
 * Hello world!
 *
 */
import Utils.Clock;
import akka.actor.ActorRef;
import akka.actor.DeadLetter;
import akka.actor.Props;
import akka.actor.UntypedActor;
import java.util.ArrayList;
import java.util.List;

public class AkkaApp extends UntypedActor {

    int counterMsgReceivedFromGreeters = 0;
    int nbActors = 1000;
    Clock totalTime = new Clock("Clocking total time to process " + nbActors + " workers using akka");
    long totalResult = 0;

    @Override
    public void preStart() {
        // create the greeter actors
        List<ActorRef> actorRefs = new ArrayList();
        for (int i = 1; i <= nbActors; i++) {
            final ActorRef greeter = getContext().actorOf(Props.create(TestOperator.class, i));
            actorRefs.add(greeter);
        }
        // tell it to perform the test (choose TEST1 or TEST2)
        for (ActorRef actorRef : actorRefs) {
            actorRef.tell(TestOperator.Msg.TEST1, getSelf());
        }
    }

    @Override
    public void onReceive(Object msg) {
        counterMsgReceivedFromGreeters++;
//        System.out.println("msg received: " + counterMsgReceivedFromGreeters);
        if (msg instanceof DeadLetter) {
            System.out.println(msg);
        } else if (msg instanceof Long) {
            totalResult = totalResult + (Long) msg;
            if (counterMsgReceivedFromGreeters == nbActors) {
                System.out.println("totalResult is: " + totalResult);
                getContext().stop(getSelf());
                totalTime.closeAndPrintClock();

            }

        } else {
            unhandled(msg);
        }
    }

    @Override
    public void postStop() {
        getContext().stop(getSelf());

    }

}
