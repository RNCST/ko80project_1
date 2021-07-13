package util;

import javax.swing.*;
import javax.swing.text.*;


/**
 * JTextField 글자수 제한하는 클래스 
 * @author OSH
 *
 */
public class BoundDocument extends PlainDocument {
	protected int charLimit;
	protected JTextComponent textComp;

	public BoundDocument(int charLimit) {
		this.charLimit = charLimit;
	}

	public BoundDocument(int charLimit, JTextComponent textComp) {
		this.charLimit = charLimit;
		this.textComp = textComp;
	}

	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		if (textComp.getText().getBytes().length + str.getBytes().length <= charLimit) {
			super.insertString(offs, str, a);
		}
	}
}