package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Ticket {
    private int id;
    private String name;
    private int estimate;
    private boolean completed;

    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEstimate() {
        return estimate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void complete() {
        completed = true;
    }
}

class UserStory extends Ticket {
    private List<UserStory> dependencies;

    public UserStory(int id, String name, int estimate, UserStory... dependencies) {
        super(id, name, estimate);
        this.dependencies = Arrays.asList(dependencies);
    }

    public List<UserStory> getDependencies() {
        return new ArrayList<>(dependencies);
    }

    @Override
    public void complete() {
        boolean allDependenciesCompleted = dependencies.stream().allMatch(UserStory::isCompleted);
        if (allDependenciesCompleted) {
            super.complete();
        }
    }

    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();
    }
}

class Bug extends Ticket {
    private UserStory relatedUserStory;

    private Bug(int id, String name, int estimate, UserStory relatedUserStory) {
        super(id, name, estimate);
        this.relatedUserStory = relatedUserStory;
    }

    public static Bug createBug(int id, String name, int estimate, UserStory relatedUserStory) {
        if (relatedUserStory == null || !relatedUserStory.isCompleted()) {
            return null;
        }
        return new Bug(id, name, estimate, relatedUserStory);
    }

    @Override
    public String toString() {
        return "[Bug " + getId() + "] " + relatedUserStory.getName() + ": " + getName();
    }

    public UserStory getRelatedUserStory() {
        return relatedUserStory;
    }
}

class Sprint {
    private int timeCapacity;
    private int ticketsLimit;
    private List<Ticket> tickets;

    public Sprint(int timeCapacity, int ticketsLimit) {
        this.timeCapacity = timeCapacity;
        this.ticketsLimit = ticketsLimit;
        this.tickets = new ArrayList<>();
    }

    public boolean addUserStory(UserStory userStory) {
        if (userStory == null || userStory.isCompleted() || tickets.size() >= ticketsLimit) {
            return false;
        }

        for (UserStory dependency : userStory.getDependencies()) {
            if (!tickets.contains(dependency)) {
                return false;
            }
        }

        int totalEstimate = tickets.stream().mapToInt(Ticket::getEstimate).sum();
        if (totalEstimate + userStory.getEstimate() > timeCapacity) {
            return false;
        }

        tickets.add(userStory);
        return true;
    }

    public boolean addBug(Bug bugReport) {
        if (bugReport == null || bugReport.isCompleted() || tickets.size() >= ticketsLimit) {
            return false;
        }

        if (!tickets.contains(bugReport.getRelatedUserStory())) {
            return false;
        }

        tickets.add(bugReport);
        return true;
    }

    public List<Ticket> getTickets() {
        return new ArrayList<>(tickets);
    }
}

public class SprintPlanning {
    public static void main(String[] args) {
        // Create user stories with dependencies
        UserStory dependency1 = new UserStory(1, "Dependency 1", 4);
        UserStory dependency2 = new UserStory(2, "Dependency 2", 3);
        UserStory userStory1 = new UserStory(3, "User Story 1", 5, dependency1, dependency2);

        // Create bugs related to user stories
        Bug bug1 = Bug.createBug(1, "Bug 1", 2, userStory1);

        // Create a sprint
        Sprint sprint = new Sprint(10, 5); // Time capacity of 10 hours, ticket limit of 5

        // Add user story and bug to the sprint
        boolean userStoryAdded = sprint.addUserStory(userStory1);
        boolean bugAdded = sprint.addBug(bug1);

        // Print sprint tickets
        System.out.println("Sprint tickets:");
        for (Ticket ticket : sprint.getTickets()) {
            System.out.println(ticket);
        }
    }
}
