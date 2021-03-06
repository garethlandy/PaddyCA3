/*
 * 
 * This is a dialog for adding new Employees and saving records to file
 * 
 * */



import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


import net.miginfocom.swing.MigLayout;

public class AddRecordDialog extends JDialog implements ActionListener {
	JTextField idField, ppsField, surnameField, firstNameField, salaryField;
	JComboBox<String> genderCombo, departmentCombo, fullTimeCombo;
	JButton save, cancel;
	EmployeeDetails parent;
	CheckInput ci = new CheckInput();
	// constructor for add record dialog
	public AddRecordDialog(EmployeeDetails parent) {
		setTitle("Add Record");
		setModal(true);
		this.parent = parent;
		this.parent.setEnabled(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane(dialogPane());
		setContentPane(scrollPane);
		
		getRootPane().setDefaultButton(save);
		
		setSize(500, 370);
		setLocation(350, 250);
		setVisible(true);
	}// end AddRecordDialog

	// initialize dialog container
	public Container dialogPane() {
		JPanel empDetails, buttonPanel;
		empDetails = new JPanel(new MigLayout());
		buttonPanel = new JPanel();
		JTextField field;

		empDetails.setBorder(BorderFactory.createTitledBorder("Employee Details"));

		empDetails.add(new JLabel("ID:"), migLayout2());
		empDetails.add(idField = new JTextField(20), migLayout3());
		idField.setEditable(false);
		

		empDetails.add(new JLabel("PPS Number:"), migLayout2());
		empDetails.add(ppsField = new JTextField(20), migLayout3());

		empDetails.add(new JLabel("Surname:"), migLayout2());
		empDetails.add(surnameField = new JTextField(20), migLayout3());

		empDetails.add(new JLabel("First Name:"), migLayout2());
		empDetails.add(firstNameField = new JTextField(20), migLayout3());

		empDetails.add(new JLabel("Gender:"), migLayout2());
		empDetails.add(genderCombo = new JComboBox<String>(this.parent.gender), migLayout3());

		empDetails.add(new JLabel("Department:"), migLayout2());
		empDetails.add(departmentCombo = new JComboBox<String>(this.parent.department), migLayout3());

		empDetails.add(new JLabel("Salary:"), migLayout2());
		empDetails.add(salaryField = new JTextField(20), migLayout3());

		empDetails.add(new JLabel("Full Time:"), migLayout2());
		empDetails.add(fullTimeCombo = new JComboBox<String>(this.parent.fullTime), migLayout3());

		buttonPanel.add(save = new JButton("Save"));
		save.addActionListener(this);
		save.requestFocus();
		buttonPanel.add(cancel = new JButton("Cancel"));
		cancel.addActionListener(this);

		empDetails.add(buttonPanel, "span 2,"+migLayout3());
		// loop through all panel components and add fonts and listeners
		for (int i = 0; i < empDetails.getComponentCount(); i++) {
			empDetails.getComponent(i).setFont(this.parent.font1);
			if (empDetails.getComponent(i) instanceof JComboBox) {
				empDetails.getComponent(i).setBackground(Color.WHITE);
			}// end if
			else if(empDetails.getComponent(i) instanceof JTextField){
				field = (JTextField) empDetails.getComponent(i);
				if(field == ppsField)
					field.setDocument(new JTextFieldLimit(7));
				else
				field.setDocument(new JTextFieldLimit(20));
			}// end else if
		}// end for
		idField.setText(Integer.toString(this.parent.getNextFreeId()));
		return empDetails;
	}
	
	//Standard MigLayout with 3 parameters -- growx, pushx, wrap
	public String migLayout3() {
		return "growx, pushx, wrap";		
	}
	//Standard MigLayout with 2 parameters -- growx, pushx
	public String migLayout2() {
		return "growx, pushx";		
	}

	// add record to file
	public void addRecord() {
		boolean fullTime = false;
		Employee theEmployee;

		if (((String) fullTimeCombo.getSelectedItem()).equalsIgnoreCase("Yes"))
			fullTime = true;
		// create new Employee record with details from text fields
		theEmployee = new Employee(Integer.parseInt(idField.getText()), ppsField.getText().toUpperCase(), surnameField.getText().toUpperCase(),
				firstNameField.getText().toUpperCase(), genderCombo.getSelectedItem().toString().charAt(0),
				departmentCombo.getSelectedItem().toString(), Double.parseDouble(salaryField.getText()), fullTime);
		this.parent.currentEmployee = theEmployee;
		this.parent.addRecord(theEmployee);
		this.parent.displayRecords(theEmployee);
	}
	
	

	// check for input in text fields
	public boolean checkInput() {
		
		boolean check = ci.checkUserInput(
				ppsField, 
				surnameField, 
				firstNameField, 
				genderCombo, 
				departmentCombo, 
				salaryField, 
				fullTimeCombo, 
				1,
				this.parent.getApplication(), 
				this.parent.getFile()
				);
		
		

		return check;
	}// end checkInput

	// set text field to white colour
	public void setToWhite() {
		ppsField.setBackground(Colours.COLOUR_WHITE);
		surnameField.setBackground(Colours.COLOUR_WHITE);
		firstNameField.setBackground(Colours.COLOUR_WHITE);
		salaryField.setBackground(Colours.COLOUR_WHITE);
		genderCombo.setBackground(Colours.COLOUR_WHITE);
		departmentCombo.setBackground(Colours.COLOUR_WHITE);
		fullTimeCombo.setBackground(Colours.COLOUR_WHITE);
	}// end setToWhite

	// action performed
	public void actionPerformed(ActionEvent e) {
		// if chosen option save, save record to file
		if (e.getSource() == save) {
			// if inputs correct, save record
			if (checkInput()) {
				addRecord();// add record to file
				dispose();// dispose dialog
				this.parent.changesMade = true;
			}// end if
			// else display message and set text fields to white colour
			else {
				JOptionPane.showMessageDialog(null, "Wrong values or format! Please check!");
				setToWhite();
			}// end else
		}// end if
		else if (e.getSource() == cancel)
			dispose();// dispose dialog
	}// end actionPerformed
}// end class AddRecordDialog