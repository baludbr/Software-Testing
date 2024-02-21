package practice;

import java.util.ArrayList;
import java.util.List;

interface Task {
    boolean execute();
    boolean isFinished();
}

class CountDownTask implements Task {
    private int value;

    public CountDownTask(int value) {
        this.value = Math.max(0, value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean execute() {
        if (!isFinished()) {
            value--;
            return true;
        }
        return false;
    }

    @Override
    public boolean isFinished() {
        return value == 0;
    }
}

class CompleteByRequestTask implements Task {
    private boolean finished;

    public CompleteByRequestTask() {
        this.finished = false;
    }

    public void complete() {
        finished = true;
    }

    @Override
    public boolean execute() {
        if (!isFinished()) {
            complete();
            return true;
        }
        return false;
    }

    @Override
    public boolean isFinished() {
        return finished;
    }
}

class TaskCarousel {
    private int capacity;
    private List<Task> tasks;
    private int currentTaskIndex;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        this.tasks = new ArrayList<>();
        this.currentTaskIndex = -1;
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public boolean isFull() {
        return tasks.size() == capacity;
    }

    public boolean addTask(Task task) {
        if (task == null || task.isFinished() || isFull()) {
            return false;
        }
        tasks.add(task);
        return true;
    }

    public boolean execute() {
        if (isEmpty()) {
            return false;
        }

        currentTaskIndex = (currentTaskIndex + 1) % tasks.size();
        Task currentTask = tasks.get(currentTaskIndex);
        boolean taskExecuted = currentTask.execute();

        if (currentTask.isFinished()) {
            tasks.remove(currentTaskIndex);
            currentTaskIndex--;
        }

        return taskExecuted;
    }
}

public class TaskCarouselMain {
    public static void main(String[] args) {
        TaskCarousel carousel = new TaskCarousel(4);
        System.out.println(carousel.isEmpty()); //true
        System.out.println(carousel.isFull()); //false
        System.out.println(carousel.execute()); //false
        CountDownTask task = new CountDownTask(2);
        System.out.println(carousel.addTask(task)); //true
        System.out.println(carousel.isEmpty()); //false
        System.out.println(carousel.isFull()); // false
        System.out.println(task.getValue()); //2
        System.out.println(carousel.execute()); //true
        System.out.println(task.getValue()); //1
        System.out.println(carousel.execute()); //true
        System.out.println(task.getValue()); //0
        System.out.println(carousel.execute()); //false
        System.out.println(carousel.isEmpty()); //true
    }
}