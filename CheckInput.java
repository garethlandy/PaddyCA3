
import java.io.File;

 import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

 public class CheckInput {
	public boolean checkUserInput(JTextField ppsField, JTextField surnameField, JTextField firstNameField,
			JComboBox<String> genderCombo, JComboBox<String> departmentCombo, JTextField salaryField,
			JComboBox<String> fullTimeCombo,long currentPosition,RandomFile application,File file) {
		boolean valid = true;
		EmployeeDetails ed = new EmployeeDetails();
		if (ppsField.isEditable() && ppsField.getText().trim().isEmpty()) {
			ppsField.setBackground(Colours.COLOUR_RED);
			valid = false;
		}
		if(ppsField.isEditable() && correctPps(ppsField.getText().trim(), currentPosition, application, file)) {
			ppsField.setBackground(Colours.COLOUR_RED);
			valid = false;
		}
		if (surnameField.isEditable() && surnameField.getText().trim().isEmpty()) {
			surnameField.setBackground(Colours.COLOUR_RED);
			valid = false;
		}
		if (firstNameField.isEditable() && firstNameField.getText().trim().isEmpty()) {
			firstNameField.setBackground(Colours.COLOUR_RED);
			valid = false;
		}
		if (genderCombo.getSelectedIndex() == 0 && genderCombo.isEnabled()) {
			genderCombo.setBackground(Colours.COLOUR_RED);
			valid = false;
		}
		if (departmentCombo.getSelectedIndex() == 0 && departmentCombo.isEnabled()) {
			departmentCombo.setBackground(Colours.COLOUR_RED);
			valid = false;
		}
		try {// try to get values from text field
			// check if salary is greater than 0
			if (Double.parseDouble(salaryField.getText()) < 0) {
				salaryField.setBackground(Colours.COLOUR_RED);
				valid = false;
			}
		} catch (NumberFormatException num) {
			if (salaryField.isEditable()) {
				salaryField.setBackground(Colours.COLOUR_RED);
				valid = false;
			} // end if
		} // end catch
		if (fullTimeCombo.getSelectedIndex() == 0 && fullTimeCombo.isEnabled()) {
			fullTimeCombo.setBackground(Colours.COLOUR_RED);
			valid = false;
		}

 		if (!valid)
			JOptionPane.showMessageDialog(null, "Wrong values or format! Please check!");
		
		if (ppsField.isEditable()) {
			setToWhite(ppsField, surnameField, firstNameField, salaryField, genderCombo, departmentCombo,
					fullTimeCombo);

 		}
		return valid;
	}

 	private void setToWhite(JTextField ppsField, JTextField surnameField, JTextField firstNameField,
			JTextField salaryField, JComboBox<String> genderCombo, JComboBox<String> departmentCombo,
			JComboBox<String> fullTimeCombo) {
 		ppsField.setBackground(UIManager.getColor(Colours.COLOUR_WHITE));
		surnameField.setBackground(UIManager.getColor(Colours.COLOUR_WHITE));
		firstNameField.setBackground(UIManager.getColor(Colours.COLOUR_WHITE));
		salaryField.setBackground(UIManager.getColor(Colours.COLOUR_WHITE));
		genderCombo.setBackground(UIManager.getColor(Colours.COLOUR_WHITE));
		departmentCombo.setBackground(UIManager.getColor(Colours.COLOUR_WHITE));
		fullTimeCombo.setBackground(UIManager.getColor(Colours.COLOUR_WHITE));
	}

 	public boolean correctPps(String pps, long currentPosition,RandomFile application, File file) {
		boolean ppsExist = false;
		if (pps.length() == 7) {
			if (pps.matches("[0-9][0-9][0-9][0-9][0-9][0-9][a-zA-Z]")) {
				application.openReadFile(file.getAbsolutePath());
				
				ppsExist = application.isPpsExist(pps, currentPosition);
				application.closeReadFile();
			} else
				ppsExist = true;
		} else
			ppsExist = true;

 		return ppsExist;
	}


 }
