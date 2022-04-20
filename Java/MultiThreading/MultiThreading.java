package Java.MultiThreading;

/**Java provides built-in support for multithreaded programming. 
 * A multithreaded program contains two or more parts that can run concurrently. 
 * Each part of such a program is called a thread, and each thread defines a separate path of 
 * execution. Thus, multithreading is a specialized form of multitasking. */

 /**The java thread model  */

 /**The Java run-time system depends on threads for many things, and all the class libraries are 
  * designed with multithreading in mind. In fact, Java uses threads to enable the entire 
  environment to be asynchronous. This helps reduce inefficiency by preventing the waste of CPU 
  cycles. */


  /**Thread Priorities **/
  /** Java assigns to each thread a priority that determines how that thread should be treated with 
   * respect to the others. Thread priorities are integers that specify the relative priority of one
   * thread to another. As an absolute value, a priority is meaningless; a higher-priority thread
   * doesn’t run any faster than a lower-priority thread if it is the only thread running. Instead,
   * a thread’s priority is used to decide when to switch from one running thread to the next. 
   * This is called a context switch. The rules that determine when a context switch takes place are 
   * simple:• A thread can voluntarily relinquish control. This is done by explicitly yielding, 
   * sleeping, or blocking on pending I/O. In this scenario, all other threads are examined, and the
   * highest-priority thread that is ready to run is given the CPU.• A thread can be preempted by
   * a higher-priority thread. In this case, a lower-priority thread that does not yield the 
   * processor is simply preempted—no matter what it is doing—by a higher-priority thread. 
   * Basically, as soon as a higher-priority thread wants to run, it does. This is called 
   * preemptive multitasking.In cases where two threads with the same priority are competing 
   * for CPU cycles, the situation is a bit complicated. For operating systems such as Windows, 
   * threads of equal priority are time-sliced automatically in round-robin fashion. For other 
   * types of operating systems, threads of equal priority must voluntarily yield control to their 
   * peers. If they don’t, the other threads will not run */
public class MultiThreading {

    public static void main(String[] args) {
        
    }
    
}
