package proj_back;

import javax.swing.*;
import javax.swing.text.*;

/**
 * Title: 텍스트 필드의 글자수 제한 도큐먼트 Description: Copyright: Copyright (c) 2001
 * Company:(주)피플넷 커뮤니케이션즈
 * 
 * @author
 * @version 1.0
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