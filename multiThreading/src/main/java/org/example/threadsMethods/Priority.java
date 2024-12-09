package org.example.threadsMethods;

public class Priority extends Thread {
    public Priority(String name) {
        super ( name );
    }

    public static void main(String[] args) {
        Priority l = new Priority ( "low" );
        Priority m = new Priority ( "med" );
        Priority h = new Priority ( "high" );
        l.setPriority ( Thread.MIN_PRIORITY );
        m.setPriority ( Thread.NORM_PRIORITY );
        h.setPriority ( Thread.MAX_PRIORITY );
        l.start ( );
        m.start ( );
        h.start ( );
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println ( Thread.currentThread ( ).getName ( ) + " priority  => "
                    + Thread.currentThread ( ).getPriority ( ) + " count => " + i );
            String a= " ";
            for (int j = 0; j < 1000; j++) {
                a+="a";
            }
            try {
                Thread.sleep ( 1000 );
            }
            catch ( InterruptedException e ) {
                throw new RuntimeException ( e );
            }
        }

    }
}
