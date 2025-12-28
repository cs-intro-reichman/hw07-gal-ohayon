public class LocalTester {
    public static final int BUFFER_SIZE = 3; 
    public static TestHandler runner = new TestHandler();

    public static void main(String[] args) {
        StdOut.println("Starting the Debugging Tool..."); 
        TesterQuestionEnum selectedOption = null;
        String userInput = "";
        In inputReader = new In();
        TesterQuestionEnum[] allTasks = TesterQuestionEnum.values();
       
        boolean shouldRunAll = false;
        
        while (selectedOption == null) {
            StdOut.println("Select a task number or name to begin testing:\n");
            for (int i = 0; i < allTasks.length; i++) {
                StdOut.printf("%d] %s - (%s)\n", (i + 1), allTasks[i], allTasks[i].getQuestion());
            }
            StdOut.println((allTasks.length + 1) + ". Execute All Tests");
            
            StdOut.println("\nYour choice: ");
            userInput = inputReader.readLine().trim().toLowerCase().replace(" ", "");

            if (userInput.equals("all") || userInput.isEmpty() || userInput.equals(String.valueOf(allTasks.length + 1))) {
                shouldRunAll = true;
                break;
            }
            selectedOption = findMatchingQuestion(userInput);
        }

        if (shouldRunAll) {
            for (TesterQuestionEnum task : allTasks) {
                runner.questionDecider(task, task.getArgsPassed().split(" "));
            }
        } else {
            runner.questionDecider(selectedOption, selectedOption.getArgsPassed().split(" "));
        }
        runner.conclusion();
    }

    public static TesterQuestionEnum findMatchingQuestion(String rawInput) {
        TesterQuestionEnum[] options = TesterQuestionEnum.values();
        for (int i = 0; i < options.length; i++) {
            try {
                if (options[i].name().equalsIgnoreCase(rawInput)) {
                    return options[i];
                }
            } catch (Exception e) {  }

            if (options[i].getQuestion().equalsIgnoreCase(rawInput) || rawInput.equals(String.valueOf(i + 1))) {
                return options[i];
            }
        }
        return null;
    }
}