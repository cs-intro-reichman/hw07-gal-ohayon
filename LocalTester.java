public class LocalTester {
    public static final int N_K_OUTPUT_LENGTH = 3; 
    
    public static TestHandler runner = new TestHandler();

    public static void main(String[] args) {
        StdOut.println("Starting the Auto-Tester..."); 
        TesterQuestionEnum selectedOption = null;
        String userInput = "";
        In inputReader = new In();
        TesterQuestionEnum[] allTasks = TesterQuestionEnum.values();
       
        while (selectedOption == null) {
            StdOut.println("Please select the question or index you want to verify:\n");
            for (int i = 0; i < allTasks.length; i++) {
                StdOut.println((i + 1) + ". " + allTasks[i] + " (" + allTasks[i].getQuestion() + ")");
            }
            StdOut.println((allTasks.length + 1) + ". Run Everything");
            
            StdOut.println("");
            userInput = inputReader.readLine().trim().toLowerCase().replace(" ", "");

            if (userInput.equals("all") || userInput.isEmpty() || userInput.equals(String.valueOf(allTasks.length + 1))) {
                break;
            }
            selectedOption = findMatchingTask(userInput);
        }

        if (userInput.equals("all") || userInput.equals(String.valueOf(allTasks.length + 1))) {
            for (TesterQuestionEnum task : allTasks) {
                runner.questionDecider(task, task.getArgsPassed().split(" "));
            }
        } else {
            runner.questionDecider(selectedOption, selectedOption.getArgsPassed().split(" "));
        }
        runner.conclusion();
    }

    // שינוי שם הפונקציה מ-isValidQuestion ל-findMatchingTask
    public static TesterQuestionEnum findMatchingTask(String rawInput) {
        TesterQuestionEnum[] options = TesterQuestionEnum.values();
        for (int i = 0; i < options.length; i++) {
            try {
                if (options[i].name().equalsIgnoreCase(rawInput)) {
                    return options[i];
                }
            } catch (Exception e) {
            }
            
            if (options[i].getQuestion().toLowerCase().equals(rawInput.toLowerCase()) || rawInput.equals(String.valueOf(i + 1))) {
                return options[i];
            }
        }
        return null;
    }
}