public interface ISurprise {

    // Opens the surprise and enjoys it
    void enjoy();

    // method added as update after classes already had implemented the interface
    default void newMethod() {
        System.out.println("Method 'void newMethod()' not implemented in " +
                getClass().getName());
    }
}
