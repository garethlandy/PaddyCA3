/*
 * 
 * This is the dialog for Employee search by ID
 * 
 * */

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class SearchByIdDialog extends SearchByDialog implements ActionListener {
	EmployeeDetails parent;
	JButton search, cancel;
	JTextField searchField;
	SearchByDialog searchByDialog;
	String id = "id";
	
	// constructor for SearchByIdDialog 
	public SearchByIdDialog(EmployeeDetails parent) {
		
		super(parent);		
		
	}// end SearchByIdDialog
	
	// initialize search container
	public Container searchPane() {
//		JPanel searchPanel = new JPanel(new GridLayout(3, 1));
//		JPanel textPanel = new JPanel();
//		JPanel buttonPanel = new JPanel();
//		JLabel searchLabel;
//
//		searchPanel.add(new JLabel("Search by ID"));
//
//		textPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
//		textPanel.add(searchLabel = new JLabel("Enter ID:"));
//		searchLabel.setFont(this.parent.font1);
//		textPanel.add(searchField = new JTextField(20));
//		searchField.setFont(this.parent.font1);
//		searchField.setDocument(new JTextFieldLimit(20));
//		
//		buttonPanel.add(search = new JButton("Search"));
//		search.addActionListener(this);
//		search.requestFocus();
//		
//		buttonPanel.add(cancel = new JButton("Cancel"));
//		cancel.addActionListener(this);
//
//		searchPanel.add(textPanel);
//		searchPanel.add(buttonPanel);
		System.out.println("xxxxxxxxxxxx");
		
		return super.searchPane();
	}// end searchPane

	
	// action listener for save and cancel button
		public void actionPerformed(ActionEvent e) {
			// if option search, search for Employee
			if(e.getSource() == search){
				this.parent.searchBySurnameField.setText(searchField.getText());
				// search Employee by surname
				this.parent.searchEmployeeBySurname();
				dispose();// dispose dialog
			}// end if
			// else dispose dialog
			else if(e.getSource() == cancel)
				dispose();// dispose dialog
		}// end actionPerformed
}// end class searchByIdDialog
