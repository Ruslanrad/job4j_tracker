package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    private final Output output;

    public FindByNameAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать заявки по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
       output.println("=== Показать заявки по имени ===");
        String name = input.askStr("Введите имя заявки: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
               output.println(item);
            }
        } else {
           output.println("Заявка с введенным именем: " + name + " не найдена.");
        }
        return true;
    }
}
