package Lab5.design_patterns_revisited.revisited.decorator;

import java.util.function.Function;
import java.util.stream.Stream;

public class NotifierDecorator {
    public static final Notifier BASIC = message ->
            System.out.println("Sending SMS: " + message);

    public static final Function<Notifier, Notifier> withFacebook = notifier ->
            message -> {
                notifier.send(message);
                System.out.println("Posting on Facebook: " + message);
            };

    public static final Function<Notifier, Notifier> withSlack = notifier ->
            message -> {
                notifier.send(message);
                System.out.println("Sending Slack message: " + message);
            };

    @SafeVarargs
    public static Notifier decorate(Notifier base, Function<Notifier, Notifier>... decorators) {
        return Stream.of(decorators)
                .reduce(base, (notifier, decorator) -> decorator.apply(notifier), (f1, f2) -> f1);
    }
}
