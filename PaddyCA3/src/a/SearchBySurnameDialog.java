package a;
///*
// * 
// * This is a dialog for searching Employees by their surname.
// * 
// * */
//
//import java.awt.Container;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.BorderFactory;
//import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextField;
//import javax.swing.border.EtchedBorder;
//
//public class SearchBySurnameDialog extends SearchByDialog implements ActionListener{
//	EmployeeDetails parent;
//	JButton search, cancel;
//	JTextField searchField;
//	String type="";
//	String dialog = "";
//	// constructor for search by surname dialog
//	public SearchBySurnameDialog(EmployeeDetails parent,String type) {
//		super(parent);
//		this.type=type;
//	}// end SearchBySurnameDialog
//	
//	// initialize search container
//	public Container searchPane() {
////		JPanel searchPanel = new JPanel(new GridLayout(3,1));
////		JPanel textPanel = new JPanel();
////		JPanel buttonPanel = new JPanel();
////		JLabel searchLabel;
////
////		searchPanel.add(new JLabel("Search by Surname"));
////	
////		textPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
////		textPanel.add(searchLabel = new JLabel("Enter Surname:"));
////		searchLabel.setFont(this.parent.font1);
////		textPanel.add(searchField = new JTextField(20));
////		searchField.setFont(this.parent.font1);
////		searchField.setDocument(new JTextFieldLimit(20));
////
////		buttonPanel.add(search = new JButton("Search"));
////		search.addActionListener(this);
////		search.requestFocus();
////		
////		buttonPanel.add(cancel = new JButton("Cancel"));
////		cancel.addActionListener(this);
////		
////		searchPanel.add(textPanel);
////		searchPanel.add(buttonPanel);
//
//		return super.searchPane();
//	}// end searchPane
//
//	// action listener for save and cancel button
//	public void actionPerformed(ActionEvent e) {
//		// if option search, search for Employee
//		super.actionPerformed(e);
//	}// end actionPerformedrformed
//}// end class SearchBySurnameDialog
