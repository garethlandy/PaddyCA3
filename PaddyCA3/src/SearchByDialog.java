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

public class SearchByDialog extends JDialog implements ActionListener {
	
	EmployeeDetails parent;
	JButton search, cancel;
	JTextField searchField;
	
	String dialog = "";
	
	
	public SearchByDialog(EmployeeDetails parent) {
	
		setModal(true);
		this.parent = parent;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		
		//this.dialog = id;
		
		JScrollPane scrollPane = new JScrollPane(searchPane());
		setContentPane(scrollPane);

		getRootPane().setDefaultButton(search);
		setSize(500, 190);
		setLocation(350, 250);
		setVisible(true);		
	}
	


	public Container searchPane() {
		JPanel searchPanel = new JPanel(new GridLayout(3, 1));
		JPanel textPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JLabel searchLabel;

		searchPanel.add(new JLabel(dialog));

		textPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		textPanel.add(searchLabel = new JLabel("Enter "+ getDialog() + " :"));
		searchLabel.setFont(this.parent.font1);
		textPanel.add(searchField = new JTextField(20));
		searchField.setFont(this.parent.font1);
		searchField.setDocument(new JTextFieldLimit(20));
		
		buttonPanel.add(search = new JButton("Search"));
		search.addActionListener(this);
		search.requestFocus();
		
		buttonPanel.add(cancel = new JButton("Cancel"));
		cancel.addActionListener(this);

		searchPanel.add(textPanel);
		searchPanel.add(buttonPanel);

		return searchPanel;
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


	public String getDialog() {
		return dialog;
	}

	public void setDialog(String dialog) {
		this.dialog = dialog;
	}
	
	}
	


