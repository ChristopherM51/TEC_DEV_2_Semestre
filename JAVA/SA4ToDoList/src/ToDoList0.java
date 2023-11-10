import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ToDoList0 extends JFrame {
    private JPanel mainPanel;
    private JTextField taskInputField;
    private JButton addButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JButton deleteButton;
    private JButton markDoneButton;
    private JComboBox<String> filterComboBox;
    private JButton clearCompletedButton;
    private List<Task> tasks;

    public ToDoList0() {
        super("To-Do List App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 435, 350);
        // Adiciona painel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        // cria arrays das tarefas e painel da lista
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        // cria campo de inserção de tarefa, botões e filtro
        taskInputField = new JTextField();
        addButton = new JButton("Adicionar");
        deleteButton = new JButton("Excluir");
        markDoneButton = new JButton("Concluir");
        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas", "Concluídas" });
        clearCompletedButton = new JButton("Limpar Concluídas");
        // adiciona campo de inserção e botão de adesão ao painel
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        // adiciona botões ao painel de botão na parte inferior do painel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);
        // Crie um painel para conter o JLabel e o inputPanel
        JPanel titleAndInputPanel = new JPanel(new BorderLayout());
        // Adiciona o JLabel "Lista de Tarefas" ao painel no norte
        JLabel titleLabel = new JLabel("Aplicativo de Tarefas");
        titleAndInputPanel.add(titleLabel, BorderLayout.NORTH);
        // Adicione o inputPanel ao painel no centro
        titleAndInputPanel.add(inputPanel, BorderLayout.CENTER);
        // Adiciona o JLabel "Lista de Tarefas" ao painel no norte
        JLabel titLabel2 = new JLabel("Painel de Tarefas");
        titleAndInputPanel.add(titLabel2, BorderLayout.SOUTH);
        // Agora, adicione o titleAndInputPanel ao mainPanel na região norte
        mainPanel.add(titleAndInputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Adicione descrições (tooltips) aos botões
        addButton.setToolTipText("Adicionar uma nova tarefa");
        deleteButton.setToolTipText("Excluir a tarefa selecionada");
        markDoneButton.setToolTipText("Marcar a tarefa como concluída");
        clearCompletedButton.setToolTipText("Limpar tarefas concluídas");
        taskInputField.setToolTipText("Digite a tarefa que deseja adicionar e pressione Enter ou clique em 'Adicionar'.");
        filterComboBox.setToolTipText("Filtrar tarefas por status: Todas, Ativas ou Concluídas");
        // seta o painel como visivel
        this.add(mainPanel);
        this.setVisible(true);
        // cria ouvintes de ação
        // ouvinte de ação para addButton com click do mouse
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });
        // ouvinte para addButton com tecla Enter
        taskInputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addTask();
                }
            }

        });
        // ouvinte para deleteButton com click de mouse
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTask();
            }
        });
        // ouvinte para deleteButton com botão Delete
        taskList.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    deleteTask();
                }
            }
        });
        // ouvinte de botão de conclusão de tarefa
        markDoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markTaskDone();
            }
        });
        // ouvinte de conclusão de tarefa com duplo click
        taskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    markTaskDoneDoubleClick();
                }
            }
        });
        // ouvinte de clearCompleteButton -> limpa tarefas concluidas
        clearCompletedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearCompletedTasks();
            }
        });
        // ouvinte de filterComboBox -> filtra tarefas por status
        filterComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterTasks();
            }
        });
    }

    // Adiciona uma tarefa
    private void addTask() {
        try {
            String taskDescription = taskInputField.getText().trim();
            if (taskDescription.isEmpty()) {
                throw new Exception("Por favor, insira uma descrição para a tarefa.");
            }

            Task newTask = new Task(taskDescription);
            tasks.add(newTask);
            updateTaskList();
            taskInputField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao adicionar tarefa", JOptionPane.ERROR_MESSAGE);
        }
    }

    // deleta uma tarefa
    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Object[] options = { "NÃO", "SIM" };
            int acao = JOptionPane.showOptionDialog(
                    null,
                    "Tem Certeza que deseja Excluir?",
                    "Confirmação",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (acao == 1) {
                tasks.remove(selectedIndex);
                updateTaskList();
            }
        }
    }

    // seta tarefa como concluida
    private void markTaskDone() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Task task = tasks.get(selectedIndex);
            int acao = JOptionPane.showOptionDialog(
                    null,
                    "Tem Certeza que deseja marcar essa tarefa como Concluída?",
                    "Confirmação",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    new Object[] { "NÃO", "SIM" },
                    "NÃO");
            if (acao == 1) {
                task.setDone(true);
                updateTaskList();
            }
        }
    }

    // seta tarefa como concluida com duplo click
    private void markTaskDoneDoubleClick() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Task task = tasks.get(selectedIndex);
            int acao = JOptionPane.showOptionDialog(
                    null,
                    "Tem Certeza que deseja marcar essa tarefa como Concluída?",
                    "Confirmação",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    new Object[] { "NÃO", "SIM" },
                    "NÃO");
            if (acao == 1) {
                task.setDone(true);
                updateTaskList();
            }
        }
    }

    // filtra terefas por status
    private void filterTasks() {
        String filter = (String) filterComboBox.getSelectedItem();
        listModel.clear();
        for (Task task : tasks) {
            if (filter.equals("Todas") || (filter.equals("Ativas") && !task.isDone())
                    || (filter.equals("Concluídas") && task.isDone())) {
                String taskDescription = task.getDescription();

                if (!task.isDone() && filter.equals("Ativas")) {
                    taskDescription += " (Ativas)";
                } else if (task.isDone() && filter.equals("Concluídas")) {
                    taskDescription += " (Concluídas)";
                }

                listModel.addElement(taskDescription);
            }
        }
    }

    // limpa tarefas concluidas
    private void clearCompletedTasks() {
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isDone()) {
                completedTasks.add(task);
            }
        }
        if (!completedTasks.isEmpty()) {
            int acao = JOptionPane.showOptionDialog(
                    null,
                    "Tem Certeza que deseja Excluir essa Tarefa Concluída?",
                    "Confirmação",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    new Object[] { "NÃO", "SIM" },
                    "NÃO");
            if (acao == 1) {
                tasks.removeAll(completedTasks);
                updateTaskList();
            }
        }
    }

    // Atualiza a lista de tarefas
    private void updateTaskList() {
        listModel.clear();
        for (Task task : tasks) {
            String taskDescription = task.getDescription() + (task.isDone() ? " (Concluída)" : "");
            if (!task.isDone()) {
                taskDescription += " (Ativa)";
            }
            listModel.addElement(taskDescription);
        }
    }

    // executa ToDoList0
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ToDoList0();
            }
        });
    }
}