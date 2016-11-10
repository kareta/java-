package kareta.consoleui;

public abstract class Controller {
    private ViewRenderer viewRenderer = new ViewRenderer();
    private View view;

    protected Controller(View view) {
        this.view = view;
    }

    public void run()
    {
        boolean exit = false;
        while (!exit)
        {
            try {
                String choice = viewRenderer.run(view);
                exit = runChoice(choice);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public abstract boolean runChoice(String choice);
}
