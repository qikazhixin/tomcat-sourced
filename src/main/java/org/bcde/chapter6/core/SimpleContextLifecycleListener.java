package org.bcde.chapter6.core;

import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleListener;

public class SimpleContextLifecycleListener implements LifecycleListener {
    public void lifecycleEvent(LifecycleEvent lifecycleEvent) {
        Lifecycle lifecycle = lifecycleEvent.getLifecycle();
        System.out.println("SimpleContextLifecycleListener's event " +
                lifecycleEvent.getType().toString());
        if (Lifecycle.START_EVENT.equals(lifecycleEvent.getType())) {
            System.out.println("Starting context.");
        } else if (Lifecycle.STOP_EVENT.equals(lifecycleEvent.getType())) {
            System.out.println("Stoping context.");

        }
    }
}
