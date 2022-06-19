package com.sun.jdi.event;

import com.sun.jdi.ObjectReference;
import com.sun.jdi.ThreadReference;
import jdk.Exported;

@Exported
public interface MonitorContendedEnterEvent extends LocatableEvent {
   ThreadReference thread();

   ObjectReference monitor();
}
