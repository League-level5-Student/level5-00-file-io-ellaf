package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener{
	
	JFrame frame = new JFrame("To Do List");
	JPanel panel = new JPanel();
	JButton addTask = new JButton("Add Task");
	JButton viewTasks = new JButton("View Tasks");
	JButton removeTask = new JButton("Remove Task");
	JButton saveList = new JButton("Save List");
	JButton loadList = new JButton("Load List");
	ArrayList<String> tasks = new ArrayList<String>();
	
	public static void main(String[] args) {
		ToDoList toDoList = new ToDoList();
		toDoList.setup();
		
	}
	
	void setup() {
	
		frame.add(panel);
		panel.add(addTask);
		addTask.addActionListener(this);
		panel.add(viewTasks);
		viewTasks.addActionListener(this);
		panel.add(removeTask);
		removeTask.addActionListener(this);
		panel.add(saveList);
		saveList.addActionListener(this);
		panel.add(loadList);
		loadList.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(addTask)) {
		String task = JOptionPane.showInputDialog("What task would you like to add to the list?");
		tasks.add(task);
		}
		if(e.getSource().equals(viewTasks)) {
		String listOfTasks = "";
		for(int i = 0; i < tasks.size(); i++) {
		listOfTasks += "\n";
		listOfTasks += tasks.get(i);
		}
		JOptionPane.showMessageDialog(null, "Here are your current tasks:" + listOfTasks);
		}
		if(e.getSource().equals(removeTask)) {
		String toRemove = JOptionPane.showInputDialog("What task would you like to remove?");
		if(tasks.contains(toRemove)) {
		int index = tasks.indexOf(toRemove);
		tasks.remove(index);
		}
		}
		if(e.getSource().equals(saveList)) {
			try {
				FileWriter fw1 = new FileWriter("src/_03_To_Do_List/todolist.txt");
				FileWriter fw = new FileWriter("src/_03_To_Do_List/todolist.txt", true);
				
				/*
				NOTE: To append to a file that already exists, add true as a second parameter when calling the
				      FileWriter constructor.
				      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
				*/
				fw1.write("");
				if(tasks.size() != 0) {
				for(int i = 0; i < tasks.size()-1; i++) {
				fw.write(tasks.get(i));
				fw.write("\n");
				}
				fw.write(tasks.get(tasks.size()-1));
				}
				
				fw.close();
			} catch (IOException b) {
				b.printStackTrace();
			}
		}
		if(e.getSource().equals(loadList)) {
		String qualifiedName = JOptionPane.showInputDialog("What is the location of the file would you like to load your list from?");
		try {
			BufferedReader br = new BufferedReader(new FileReader(qualifiedName));
			
			String line = br.readLine();
			
			while(line != null){				
				tasks.add(line);
				System.out.println(line);
				line = br.readLine();
			}
			
			
			
			
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException b) {
			// TODO Auto-generated catch block
			b.printStackTrace();
		}
		}

	}
	
}
